package com.capsule.TaskTracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capsule.TaskTracker.entity.ParentTask;
import com.capsule.TaskTracker.entity.Task;
import com.capsule.TaskTracker.entity.User;
import com.capsule.TaskTracker.jdbc.UserDAO;

@Service
public class UserService {
	
	
	@Autowired
	UserDAO userDAO;
	
	public List<User> getUsers(){
//		System.out.println("get tasks");
		return userDAO.getUserList();
	}
	// create User
	public boolean createUser(User user) {
		return userDAO.insertUser(user);
	}
	
	// get requested user	
	public User getUser(int id) {
		return userDAO.getUser(id);
	}
	
	// delete user	
	public boolean deleteUser(int id) {
		return userDAO.deleteUser(id);
	}
	
	// Update user	
	public boolean updateUser(User user) {
		return userDAO.updateUser(user);
	}


}
