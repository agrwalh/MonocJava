package com.studentcourse.model;

public class Course {

	private int courseId;
	private String courseName;
	private String duration;
	private double fees;
	private String trainerName;

	public Course() {
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getDuration() {
		return duration;
	}

	public double getFees() {
		return fees;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
}