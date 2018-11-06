package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Task;
import com.tasks.TasksRepository;

@Service
public class TaskService {

	@Autowired
	private TasksRepository repository;

	public Iterable<Task> getAllTasks() {
		return repository.findAll();
	}

	public Optional<Task> getTaskById(Long id) {
		return repository.findById(id);
	}

	public void addTask(Task task) {
		repository.save(task);
	}
	
	public void updateTask(Task task) {
		repository.save(task);
	}
	
	public void deleteTask(Long id) {
		repository.deleteById(id);
	}

}
