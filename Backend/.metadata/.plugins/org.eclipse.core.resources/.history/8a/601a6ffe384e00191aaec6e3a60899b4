package com.capsule.TaskTracker.component;

import java.util.List;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capsule.TaskTracker.entity.ParentTask;
import com.capsule.TaskTracker.entity.Task;
import com.capsule.TaskTracker.service.ParentService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ParentControllerRest {
	
	@Autowired
	ParentService parentService;
	
	 //Get Task List
		@GetMapping(value="/getParentTasks")
		@Produces({"application/json"})
		@ResponseBody
		public List<ParentTask> getParentTasks(){
//			System.out.println("contorller");
			return parentService.getParentTasks();
		}
		
		//Get Task List
		@GetMapping(value="/getParentTask/{id}")
		@Produces({"application/json"})
		@ResponseBody
		public ParentTask getParentTask(@PathVariable int id){
//					System.out.println("contorller");
			return parentService.getParentTask(id);
		}	

}
