package com.capsule.TaskTracker.DAOTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capsule.TaskTracker.entity.ParentTask;
import com.capsule.TaskTracker.entity.Task;
import com.capsule.TaskTracker.jdbc.TaskDAO;
import com.capsule.TaskTracker.service.TaskTrackerService;

@RunWith(SpringRunner.class)
public class TaskDAOTest {
	
	@TestConfiguration
    static class TaskServiceImplTestContextConfiguration {
  
        @Bean
        public TaskTrackerService taskService() {
            return new TaskTrackerService();
        }
    }
	
	@Autowired
	TaskTrackerService taskService;
	
	@MockBean
    private TaskDAO taskDao;
	
	@Before
	public void setUp() {
		Task task = new Task(1,1,1, "Development",null,null,1,"COMPL");
		ParentTask ptask = new ParentTask(1,"Development");
		String datatohelp = "1-1-Development";
	 
	    Mockito.when(taskDao.getTask(task.getTaskId())).thenReturn(task);
	    Mockito.when(taskDao.insertTask(task)).thenReturn(true);
//	    Mockito.when(taskDao.inserParentTask(task)).thenReturn(ptask);
	    Mockito.when(taskDao.updateTask(task)).thenReturn(true);
	    Mockito.when(taskDao.deleteTask(task.getTaskId())).thenReturn(true);
	    Mockito.when(taskDao.getTaskIdbyParentNProject(datatohelp)).thenReturn(task);
	   
	    
	    
	}
	
	@Test
	public void whenValidName_thenTaskShouldBeFound() {
	    int id = 1;
	    Task found = taskService.getTask(id);
	  
	    assertTrue("mock and test are equal", found.getTaskId()==id);
	 }
	
	@Test
	public void whenTaskInserted() {
		Task taskIns = new Task(1,1,1, "Development",null,null,1,null);
		boolean success = taskService.createTask(taskIns);
		
	    assertNotNull(taskService.createTask(taskIns));
	 }
	
	@Test
	public void whenUpdateTask() {
		Task taskUpd = new Task(1,1,1, "Development",null,null,1,"NEW");
	    boolean success = taskService.updateTask(taskUpd);
	  
	    assertNotNull(taskService.updateTask(taskUpd));
	 }
	
	@Test
	public void whendeleteTask() {
		Task taskdel = new Task(1,1,1, "Development",null,null,1,"NEW");
		boolean success = taskService.deleteTask(taskdel.getTaskId());
	  
		assertNotNull(taskService.deleteTask(taskdel.getTaskId()));
	 }
	
	@Test
	public void whengetTaskIdbyParentNProject() {
		Task taskget = new Task(1,1,1, "Development",null,null,1,"NEW");
		String datatohelp = "1-1-Development";
		Task dataTask = taskService.getTaskIdbyParentNProject(datatohelp);
	  
	    assertTrue("See if insert is success", dataTask.getTaskId()==taskget.getTaskId());
	 }
	
	@Test
	public void testInsertinDao() {
		Task taskIns = new Task(1,1,1, "Development",null,null,1,"NEW");
		boolean success = taskDao.insertTask(taskIns);
		
	    assertNotNull(taskDao.insertTask(taskIns));
	}
	
	@Test
	public void gettaskInDao() {
		Task taskIns = new Task(1,1,1, "Development",null,null,1,"NEW");
		Task taskget = taskDao.getTask(taskIns.getTaskId());
		
		assertTrue("See if insert is success", taskget.getTaskId()==taskIns.getTaskId());
	}
	
	@Test
	public void deletetaskInDao() {
		Task taskDel = new Task(1,1,1, "Development",null,null,1,"NEW");
	    
	    assertNotNull(taskDao.deleteTask(taskDel.getTaskId()));
	}
	@Test
	public void updatetaskInDao() {
		Task taskUpd = new Task(1,1,1, "Development",null,null,1,"NEW");
	    
	    assertNotNull(taskDao.updateTask(taskUpd));
	}
	
	@Test
	public void getTaskIdbyParentNProjectInDao() {
		Task taskget = new Task(1,1,1, "Development",null,null,1,"NEW");
		String datatohelp = "1-1-Development";
		Task dataTask = taskDao.getTaskIdbyParentNProject(datatohelp);
	  
	    assertTrue("See if insert is success", dataTask.getTaskId()==taskget.getTaskId());
	}
}
