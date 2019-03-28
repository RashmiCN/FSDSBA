package com.capsule.TaskTracker.Exception;

public class TaskTrackerException extends Exception {
		public TaskTrackerException(String message,Exception exception) {
			super(message,exception);
		}
		
		public TaskTrackerException(String message) {
			super(message);
		}
}
