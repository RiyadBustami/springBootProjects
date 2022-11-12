package com.riyadbusttami.projectmanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riyadbusttami.projectmanager.models.Task;
import com.riyadbusttami.projectmanager.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	TaskRepository taskRepository;
	
	public Task create(Task task) {
		return taskRepository.save(task);
	}
}
