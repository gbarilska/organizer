package com.tasks;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.entity.Task;

@Repository
public interface TasksRepository extends CrudRepository<Task, Long> {

	public Iterable<Task> findAll();
	
	public Optional<Task> findById(Long id);

	public <S extends Task> S save(S entity);

	public void deleteById(Long id);

}
