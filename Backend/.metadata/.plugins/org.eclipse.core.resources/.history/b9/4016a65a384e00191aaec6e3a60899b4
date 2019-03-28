package com.capsule.TaskTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.TaskTracker.entity.ParentTask;
import com.capsule.TaskTracker.entity.Task;
import com.capsule.TaskTracker.jdbc.TaskDAO;

@Service
public class TaskTrackerService {
		
	@Autowired
	TaskDAO taskDAO;

	// Get Task list
	public List<Task> getTasks(int id){
//		System.out.println("get tasks");
		return taskDAO.getTaskList(id);
	}
	// create Task
	public boolean createTask(Task Task) {
		return taskDAO.insertTask(Task);
	}
	public Task getTask(int id) {
		return taskDAO.getTask(id);
	}
	public boolean deleteTask(int id) {
		return taskDAO.deleteTask(id);
	}
	public boolean updateTask(Task task) {
		return taskDAO.updateTask(task);
	}

//	public boolean createParentTask(ParentTask parentTask) {
//		// TODO Auto-generated method stub
//		return taskDAO.in(parentTask);
//	}
	
//	public List<ParentTask> getParentTasks(int id) {
//		// TODO Auto-generated method stub
//		return taskDAO.getParentTasks(id);
//	}
	public Task getTaskIdbyParentNProject(String datatohelp) {
		// TODO Auto-generated method stub
		return taskDAO.getTaskIdbyParentNProject(datatohelp);
	}
	
	public boolean completeTask(int id) {
		
		return taskDAO.completeTask(id);
	}

}
