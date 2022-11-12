package com.riyadbusttami.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riyadbusttami.projectmanager.models.MembersProjects;
import com.riyadbusttami.projectmanager.models.Project;
import com.riyadbusttami.projectmanager.models.Task;
import com.riyadbusttami.projectmanager.models.User;
import com.riyadbusttami.projectmanager.services.MembersProjectsService;
import com.riyadbusttami.projectmanager.services.ProjectService;
import com.riyadbusttami.projectmanager.services.TaskService;
import com.riyadbusttami.projectmanager.services.UserService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	@Autowired
	UserService userService;
	@Autowired
	MembersProjectsService memProServ;
	@Autowired
	TaskService taskService;
	
	@GetMapping("")
	public String index(HttpSession session) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		return "redirect:/projects/dashboard";
	}
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		User currUser = userService.get((Long)session.getAttribute("userId"));
		model.addAttribute("currUser", currUser);
		model.addAttribute("allProjects",projectService.getWhereNotMember(currUser));
		model.addAttribute("yourProjects", projectService.getOwnProjectsAndMemberProjects(currUser));
		model.addAttribute("membersProjects", new MembersProjects());
		return "/projects/dashboard.jsp";
	}
	@GetMapping("/new")
	public String newProject(HttpSession session, @ModelAttribute("project")Project project) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		return "/projects/new.jsp";
	}
	@PostMapping("")
	public String create(HttpSession session, @Valid @ModelAttribute("project")Project project, BindingResult result) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		if(result.hasErrors()) {
			return "/projects/new.jsp";
		}
		else {
			projectService.create(project);
			return "redirect:/projects/dashboard";
		}
	}
	@PostMapping("/join")
	public String joinTeam(HttpSession session, @ModelAttribute("membersProjects")MembersProjects membersProjects) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		memProServ.create(membersProjects);
		return "redirect:/projects/dashboard";
	}
	@DeleteMapping("/leave/{projId}")
	public String leaveTeam(HttpSession session, @PathVariable("projId") Long projId, Model model) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		User currUser= userService.get((Long)session.getAttribute("userId"));
		Project currProject = projectService.find(projId);
		currUser.getJoinedProjects().remove(currProject);
		currProject.getMembers().remove(currUser);
		projectService.update(currProject);
		return "redirect:/projects/dashboard";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id")Long projId,HttpSession session, Model model) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		User currUser= userService.get((Long)session.getAttribute("userId"));
		Project currProject = projectService.find(projId);
		if(currProject.getLeader().getId()!=currUser.getId())return "redirect:/projects/dashboard";
		model.addAttribute("project", currProject);
		return "/projects/edit.jsp";
	}
	@PutMapping("/{id}")
	public String update(HttpSession session, @PathVariable("id")Long projId,@Valid @ModelAttribute("project")Project project, BindingResult result) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		User currUser= userService.get((Long)session.getAttribute("userId"));
		Project currProject = projectService.find(projId);
		if(currProject.getLeader().getId()!=currUser.getId())return "redirect:/projects/dashboard";
		if(result.hasErrors()) {
			return "/projects/edit.jsp"; 
		}
		else {
			project.setMembers(currProject.getMembers());
			projectService.update(project);
			return "redirect:/projects/dashboard";
		}
		
		
	}
	@GetMapping("/{id}")
	public String show(HttpSession session, Model model, @PathVariable("id")Long projId) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		Project currProject = projectService.find(projId);
		User currUser= userService.get((Long)session.getAttribute("userId"));
		model.addAttribute("isMember", currProject.getMembers().contains(currUser));
		model.addAttribute("project", currProject);
		return "/projects/show.jsp";
		
		
	}
	@GetMapping("/{id}/tasks")
	public String showTasks(HttpSession session, Model model, @PathVariable("id")Long projId) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		User currUser= userService.get((Long)session.getAttribute("userId"));
		Project currProject = projectService.find(projId);
		if(!(currProject.getMembers().contains(currUser)||currProject.getLeader().getId().equals(currUser.getId()))) return "redirect:/projects/dashboard";
		model.addAttribute("currUserFromModels",currUser);
		model.addAttribute("project", currProject);
		model.addAttribute("task", new Task());
		return "/projects/newtask.jsp";
	}
	@PostMapping("/{projId}/tasks")
	public String createTask(HttpSession session,@Valid @ModelAttribute("task")Task task, BindingResult result,Model model, @PathVariable("projId")Long projId) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		User currUser= userService.get((Long)session.getAttribute("userId"));
		Project currProject = projectService.find(projId);
		if(!(currProject.getMembers().contains(currUser)||currProject.getLeader().getId().equals(currUser.getId()))) return "redirect:/projects/dashboard";
		if(result.hasErrors()) {
			model.addAttribute("project", currProject);
			return "/projects/newtask.jsp";
		}
		else {
			taskService.create(task);
			return"redirect:/projects/"+projId+"/tasks";
		}
		
	}
	@DeleteMapping("/{id}")
	public String deleteProject(@PathVariable("id")Long projId, HttpSession session) {
		if(session.getAttribute("userId")==null)return "redirect:/";
		User currUser= userService.get((Long)session.getAttribute("userId"));
		Project currProject = projectService.find(projId);
		if(!currProject.getLeader().getId().equals(currUser.getId())) {
			return "redirect:/projects/dashboard";
		}
		else {
			projectService.delete(currProject);
			return "redirect:/projects/dashboard";
			
		}
	}
	
}
