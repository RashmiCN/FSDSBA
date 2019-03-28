package com.capsule.TaskTracker.component;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capsule.TaskTracker.Exception.TaskTrackerException;
import com.capsule.TaskTracker.entity.Task;
import com.capsule.TaskTracker.entity.User;
import com.capsule.TaskTracker.service.UserService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class UserControllerRest {
	
	@Autowired
	UserService userService;
	
	    // Get User List
		@GetMapping(value="/user")
		@Produces({"application/json"})
		@ResponseBody
		public List<User> getUsers(){
			System.out.println("User Controller");
			return userService.getUsers();
		}

		@PostMapping(value="/addUser")
		@Consumes({"application/json"})
		@ResponseBody
		public ResponseEntity<User> createUser(@RequestBody User user) throws TaskTrackerException{
//			System.out.println("task passed" + task);
			boolean isCreated = false;
			try {
				isCreated = userService.createUser(user);
			} catch (Exception e) {
				throw new TaskTrackerException("usernot created, Check if Parent task exists!",e);
			}
			
			if(isCreated){
				return new ResponseEntity<User>(HttpStatus.CREATED);
			} else {
//				return new ResponseEntity<Product>(HttpStatus.OK);
				
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header("message", "User not created, Check if User exists!").build();
			}
		}
		
		 // Edit user
		@CrossOrigin(origins = "http://localhost:4200")
		@PutMapping(value="/edituser")
		@Consumes({"application/json"})
		@ResponseBody
		public ResponseEntity<User> updateUser(@RequestBody User user) throws TaskTrackerException{
			boolean isCreated = false;
			try {
				isCreated = userService.updateUser(user);
			} catch (Exception e) {
				throw new TaskTrackerException("User not updated, Check if valid data is provided!",e);
			}
			if(isCreated){
				return new ResponseEntity<User>(HttpStatus.OK);
			} else {
//				return new ResponseEntity<Product>(HttpStatus.OK);
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).header("message", "Task Not Updated, Check Values provided").build();
			}
		}
		
		
		 // Edit user
		@CrossOrigin(origins = "http://localhost:4200")
		@PutMapping(value="/deleteUser")
		@Consumes({"application/json"})
		@ResponseBody
		public ResponseEntity<User> deleteUser(@RequestBody User user) throws TaskTrackerException{
			boolean isdeleted = false;
			System.out.println("passed id " + user.getUserId());
			try {
				isdeleted = userService.deleteUser(user.getUserId());
			} catch (Exception e) {
				throw new TaskTrackerException("User not deleted, Check if valid data is provided!",e);
			}
			if(isdeleted){
				return new ResponseEntity<User>(HttpStatus.OK);
			} else {
//				return new ResponseEntity<Product>(HttpStatus.OK);
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).header("message", "Task Not Updated, Check Values provided").build();
			}
		}
		
		
		
		
		 // get 1 user
		@GetMapping(value="/getuser/{id}")
		@Produces({"application/json"})
		@ResponseBody
		public User getUser(@PathVariable int id) throws TaskTrackerException{
			System.out.println("get 1 user" + id);
			User userFetched = null;
			try {
			    userFetched = userService.getUser(id);
			} catch (Exception e) {
				throw new TaskTrackerException("User not updated, Check if valid data is provided!",e);
			}
			return userFetched;
			
		}
		
}
