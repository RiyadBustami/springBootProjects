package com.riyadbusttami.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riyadbusttami.projectmanager.models.Project;
import com.riyadbusttami.projectmanager.models.User;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
	List<Project> findAllByMembersNotContains(User user);
	List<Project> findAllByMembersContains(User user);
	List<Project> findAllByLeader(User user);
}
