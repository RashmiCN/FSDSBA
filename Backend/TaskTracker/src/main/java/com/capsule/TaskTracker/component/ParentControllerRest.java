package com.capsule.TaskTracker.component;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capsule.TaskTracker.entity.ParentTask;
import com.capsule.TaskTracker.entity.Task;
import com.capsule.TaskTracker.service.ParentService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ParentControllerRest {
	
//	Parent Rest Controller for parent_task table
//	accepts JSON for insert and sends list of parent tasks
	
	@Autowired
	ParentService parentService;
	
	 // Get Parent Task List
		@GetMapping(value="/getParentTasks")
		@Produces({"application/json"})
		@ResponseBody
		public List<ParentTask> getParentTasks(){
			return parentService.getParentTasks();
		}
		
		//Get Parent task by parent task id
		@GetMapping(value="/getParentTask/{id}")
		@Produces({"application/json"})
		@ResponseBody
		public ParentTask getParentTask(@PathVariable int id){
//					System.out.println("contorller");
			return parentService.getParentTask(id);
		}
		
		// Create ParentTask
		@CrossOrigin(origins = "http://localhost:4200")
		@PostMapping(value="/addParentTask/{pname}")
		@Consumes({"application/json"})
		@Produces({"application/json"})
		@ResponseBody
		public String createParentTask(@PathVariable String pname) {
//			System.out.println("task passed" + parentTask);
			boolean isCreated = false;
			ParentTask parentTask = new ParentTask(pname);
			isCreated = parentService.createParentTask(parentTask);
			return pname;
		}

}
