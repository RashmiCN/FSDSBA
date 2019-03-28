package com.capsule.TaskTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskTrackerApplication extends ServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TaskTrackerApplication.class, args);
	}

}

