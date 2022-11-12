package com.riyadbusttami.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyadbusttami.projectmanager.models.Project;
import com.riyadbusttami.projectmanager.models.User;
import com.riyadbusttami.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	public Project create(Project project) {
		return projectRepository.save(project);
	}
	public void delete(Project project) {
		projectRepository.delete(project);
	}
	public Project find(Long id) {
		Optional<Project> opProject = projectRepository.findById(id);
		if(opProject.isPresent()) {
			return opProject.get();
		}
		else {
			return null;
		}
	}
	public Project update(Project project) {
		Optional<Project> opProject = projectRepository.findById(project.getId());
		if(opProject.isPresent()) {
			return projectRepository.save(project);
		}
		else {
			return null;
		}
		
	}
	
	public List<Project> getWhereNotMember(User user){
		return projectRepository.findAllByMembersNotContains(user);
	}
	
	public List<Project> getOwnProjectsAndMemberProjects(User user){
		List<Project> ownProjects = projectRepository.findAllByLeader(user);
		List<Project> memberProjects = projectRepository.findAllByMembersContains(user);
		ownProjects.addAll(memberProjects);
		return ownProjects;
	}
}
