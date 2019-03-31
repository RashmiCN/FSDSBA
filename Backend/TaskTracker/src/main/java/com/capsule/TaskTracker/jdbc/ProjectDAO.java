package com.capsule.TaskTracker.jdbc;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capsule.TaskTracker.entity.Project;
import com.capsule.TaskTracker.entity.Task;
import com.capsule.TaskTracker.entity.User;

@Repository
public class ProjectDAO {
	
	EntityManager entityManager;
	
	
	@Autowired
	public ProjectDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Autowired
	TaskDAO taskDAO;
	
	@Autowired
	UserDAO userDAO;
	
	public Project createProject(Project project) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(project);
		return project;
	}

	public Project getProject(int projectId) {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Project> query = 
				currentSession.createQuery("from Project where projectId=:id",Project.class);
		query.setParameter("id", projectId);

		
		Project existingProject = query.getSingleResult();
		
		return existingProject;
	}

	public List<Project> getProjectList() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Project> query = 
				currentSession.createQuery("from Project",Project.class);
		
		List<Project> projectList = query.getResultList();
//		System.out.println(projectList);
		
		return projectList;
	}
	
	@Transactional
	public boolean deleteProject(int projectId) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		Project existingProject = getProject(projectId);
//		Updating tasks..................................
		taskDAO.updateProjectsdelete(projectId);
//		Updating Users...................................
		userDAO.updateUsersdelete(projectId);
//		Delete project...................................
		currentSession.delete(existingProject);
		return true;
	}

	@Transactional
	public boolean updateProject(Project project) {
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println(project);
		
		currentSession.update(project);

		return true;
	}


	public Project getProjectByPName(String projectName) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		System.out.println(projectName);
		
		Query<Project> query = 
				currentSession.createQuery("from Project where project=:name",Project.class);
		query.setParameter("name", projectName);
		
		Project existingProject = query.getSingleResult();
		
		return existingProject;
	}


	
}
