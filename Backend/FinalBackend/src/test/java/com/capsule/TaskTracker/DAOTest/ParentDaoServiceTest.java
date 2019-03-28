package com.capsule.TaskTracker.DAOTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capsule.TaskTracker.entity.ParentTask;
import com.capsule.TaskTracker.entity.User;
import com.capsule.TaskTracker.jdbc.ParentDao;
import com.capsule.TaskTracker.jdbc.ProjectDAO;
import com.capsule.TaskTracker.jdbc.TaskDAO;
import com.capsule.TaskTracker.jdbc.UserDAO;
import com.capsule.TaskTracker.service.ParentService;
import com.capsule.TaskTracker.service.ProjectService;
import com.capsule.TaskTracker.service.TaskTrackerService;
import com.capsule.TaskTracker.service.UserService;

@RunWith(SpringRunner.class)
public class ParentDaoServiceTest {
	@TestConfiguration
    static class ProjectServiceImplTestContextConfiguration {
  
        @Bean
        public ProjectService projectService() {
            return new ProjectService();
        }
    }
	
	@Autowired
	ProjectService projectService;
	
	@MockBean
    private ProjectDAO projectDao;
	
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
	
	@TestConfiguration
    static class UserServiceImplTestContextConfiguration {
  
        @Bean
        public UserService userService() {
            return new UserService();
        }
    }
	
	@Autowired
	UserService userService;
	
	@MockBean
    private UserDAO userDao;
	
	@TestConfiguration
    static class ParentServiceImplTestContextConfiguration {
  
        @Bean
        public ParentService parentService() {
            return new ParentService();
        }
    }
	
	@Autowired
	ParentService parentService;
	
	@MockBean
    private ParentDao parentDao;
	
	
	@Before
	public void setUp() {
		ParentTask parent = new ParentTask(1,"ParentTask");
		
		System.out.println(parent);
	    Mockito.when(parentDao.getParentTask(parent.getParentId())).thenReturn(parent);
	    Mockito.when(parentDao.createParentTask(parent)).thenReturn(true);
	 
	}
	
	@Test
	public void whenValidName_thenParentShouldBeFound() {
	    int id = 1;
	   ParentTask pfind = parentService.getParentTask(id);
	  
	    assertTrue("mock and test are equal", pfind.getParentId()==id);
	 }
	
	@Test
	public void whenParentInserted() {
		ParentTask ptsk = new ParentTask(1,"Parenttask");
		assertNotNull(parentService.createParentTask(ptsk));
		
	 }

}
