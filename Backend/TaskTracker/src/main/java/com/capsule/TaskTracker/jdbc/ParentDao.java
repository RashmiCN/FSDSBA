package com.capsule.TaskTracker.jdbc;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capsule.TaskTracker.entity.ParentTask;
import com.capsule.TaskTracker.entity.User;

@Repository
public class ParentDao {
	
	
	EntityManager entityManager;
	
	@Autowired
	public ParentDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

//	public boolean insertParent(ParentTask parentTask) {
//		Session currentSession = entityManager.unwrap(Session.class);
//
//		currentSession.saveOrUpdate(parentTask);		
//		return true;
//	}

	public List<ParentTask> getParentTasks() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ParentTask> query = 
				currentSession.createQuery("from ParentTask",ParentTask.class);
		
		List<ParentTask> pList = query.getResultList();
		System.out.println(pList);
		
		return pList;
	}

	public ParentTask getParentTask(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<ParentTask> query = 
				currentSession.createQuery("from ParentTask where parentId=:id",ParentTask.class);
		query.setParameter("id",id);
		ParentTask pTask = query.getSingleResult();
		System.out.println(pTask);
		
		return pTask;
	}

	@Transactional
	public boolean createParentTask(ParentTask parentTask) {
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.println("inserting parent.....................");
		System.out.println("input is" + parentTask);
		currentSession.save(parentTask);
		return true;
	}

}
