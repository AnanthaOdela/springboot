package com.student.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Student")

public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String name;
	private  int age;
	private String address;
	private String rollNumber;
	private String phoneNumber;
	private String emailId;
	private String grade;
	private String createdAt;
	private String updatedAt;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Student(int studentId, String name, int age, String address, String rollNumber, String phoneNumber,
			String emailId, String grade, String createdAt, String updatedAt) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.rollNumber = rollNumber;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.grade = grade;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	public int getStudentId() {
		return studentId;
	}



	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getRollNumber() {
		return rollNumber;
	}



	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getGrade() {
		return grade;
	}



	public void setGrade(String grade) {
		this.grade = grade;
	}



	public String getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}



	public String getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}



	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", rollNumber=" + rollNumber + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", grade="
				+ grade + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
