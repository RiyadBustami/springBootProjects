package com.riyadbusttami.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyadbusttami.projectmanager.models.MembersProjects;
import com.riyadbusttami.projectmanager.models.Project;
import com.riyadbusttami.projectmanager.models.User;
@Repository
public interface MembersProjectsRepository extends CrudRepository<MembersProjects, Long> {
	List<MembersProjects> findAll();
	MembersProjects findByMemberAndProject(User member, Project project);
}
