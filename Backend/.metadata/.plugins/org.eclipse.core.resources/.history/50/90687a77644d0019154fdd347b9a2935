package com.capsule.TaskTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.TaskTracker.entity.ParentTask;
import com.capsule.TaskTracker.entity.Task;
import com.capsule.TaskTracker.jdbc.TaskDAO;
import com.capsule.TaskTracker.repository.TaskRepository;

@Service
public class TaskTrackerService {
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	TaskDAO taskDAO;

	// Get Task list
	public List<Task> getTasks(){
//		System.out.println("get tasks");
		return taskRepository.getTaskList();
	}
	// create Task
	public boolean createTask(Task Task) {
		return taskRepository.createTask(Task);
	}
	public Task getTask(int id) {
		return taskRepository.getTask(id);
	}
	public boolean deleteTask(int id) {
		return taskRepository.deleteTask(id);
	}
	public boolean updateTask(Task task) {
		return taskRepository.updateTask(task);
	}
	public boolean updateFlipTask(Task task) {
		return taskRepository.updateFlipTask(task);
	}
	public boolean createParentTask(ParentTask parentTask) {
		// TODO Auto-generated method stub
		return taskRepository.addParentTask(parentTask);
	}
	
	public List<ParentTask> getParentTasks(int id) {
		// TODO Auto-generated method stub
		return taskDAO.getParentTasks(id);
	}

}
