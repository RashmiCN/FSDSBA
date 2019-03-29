package com.capsule.TaskTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.TaskTracker.entity.ParentTask;
import com.capsule.TaskTracker.entity.Project;
import com.capsule.TaskTracker.entity.Task;
import com.capsule.TaskTracker.entity.User;
import com.capsule.TaskTracker.jdbc.ParentDao;
import com.capsule.TaskTracker.jdbc.ProjectDAO;
import com.capsule.TaskTracker.jdbc.TaskDAO;

@Service
public class ParentService {
	
	
	@Autowired
	ParentDao parentDAO;

	public List<ParentTask> getParentTasks(){
		return parentDAO.getParentTasks();
	}

	public ParentTask getParentTask(int id) {
		return parentDAO.getParentTask(id);
	}

	public boolean createParentTask(ParentTask parentTask) {
		// TODO Auto-generated method stub
		return parentDAO.createParentTask(parentTask);
	}	

}
