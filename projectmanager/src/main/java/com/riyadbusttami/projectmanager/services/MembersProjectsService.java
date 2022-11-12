package com.riyadbusttami.projectmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyadbusttami.projectmanager.models.MembersProjects;
import com.riyadbusttami.projectmanager.models.Project;
import com.riyadbusttami.projectmanager.models.User;
import com.riyadbusttami.projectmanager.repositories.MembersProjectsRepository;

@Service
public class MembersProjectsService {
	@Autowired
	MembersProjectsRepository memProRepo;
	
	public MembersProjects create(MembersProjects memPro) {
		return memProRepo.save(memPro);
	}
	public void delete(Long id) {
		memProRepo.deleteById(id);
	}
	public MembersProjects get(User member, Project project) {
		return memProRepo.findByMemberAndProject(member, project);
	}
	
	

}
