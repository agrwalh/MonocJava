package com.studentcourse.model;

public class Registration {

	private int registrationId;
	private int studentId;
	private int courseId;
	private String registrationDate;
	private String status;
	private String studentName;
	private String courseName;

	public Registration() {
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public String getStatus() {
		return status;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}