package com.student.data.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.data.exception.ResourceNotFoundException;
import com.student.data.exception.StudentServiceException;
import com.student.data.model.Student;
import com.student.data.repository.StudentRepository;
import com.student.data.util.JavaUtil;


@RestController
@RequestMapping("/api")
public class StudentController {
	
	
	    @Autowired
	    StudentRepository studentRepository;

	    @GetMapping("/allStudents")
	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    @PostMapping("/createStudent")
	    public Student createStudent( @RequestBody Student student) throws StudentServiceException {
	    	Student student1=null;
	    			  
	    	try {
	    	Date date = Calendar.getInstance().getTime();

	        // Display a date in day, month, year format
	        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        String today = formatter.format(date);
	        if("".equals(student.getName())) {
        		throw new StudentServiceException("Name is mandatory");
        	}
	        boolean flag=JavaUtil.isValid(student.getPhoneNumber());
	        if(!flag)
	        	throw new StudentServiceException("Phone Number is Invalid..Please give valid phoe number");
	        student.setCreatedAt(today);
	        student.setUpdatedAt(today);
	        
	        student1=studentRepository.save(student);
	        return student1;
	    	}
	    	catch(Exception s) {
	        	throw new StudentServiceException("Internal Server Exception while getting exception");
	        }
	    	
	    }

	    @GetMapping("/students/{id}")
	    public Student getStudentById(@PathVariable(value = "id") int studentId) throws ResourceNotFoundException {
	        return studentRepository.findById(studentId)
	                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this Id"+studentId));
	    }

	    @PutMapping("/students/{id}")
	    public Student updateStudent(@PathVariable(value = "id") int  studentId,
	                                            @RequestBody Student studentData) throws ResourceNotFoundException, StudentServiceException {

	    	Student updatedStudent=null;
	    	Student student = studentRepository.findById(studentId)
	                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this Id:"+studentId));

	        
	        try {
	        	if(studentData.getName()==null && "".equals(studentData.getName())) {
	        		throw new StudentServiceException("Name is mandatory");
	        	}
	        	 boolean flag=JavaUtil.isValid(student.getPhoneNumber());
	 	        if(!flag)
	 	        	throw new StudentServiceException("Phone Number is Invalid..Please give valid phoe number");
	        	
	 	        student.setName(studentData.getName());
	        	student.setAddress(studentData.getAddress());
	        	student.setAge(studentData.getAge());
	        	student.setEmailId(studentData.getEmailId());
	        	student.setGrade(studentData.getGrade());
	        	student.setPhoneNumber(studentData.getPhoneNumber());
	        	student.setRollNumber(studentData.getRollNumber());
	        	student.setCreatedAt(studentData.getCreatedAt());
	        	
	        
	        Date date = Calendar.getInstance().getTime();

	        // Display a date in day, month, year format
	        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        String today = formatter.format(date);
	       
	        student.setCreatedAt(today);
	        student.setUpdatedAt(today);

	         updatedStudent = studentRepository.save(student);
	         return updatedStudent;
	        }
	       
	        catch(Exception s) {
	        	throw new StudentServiceException("Internal Server Exception while getting exception");
	        }
	        
	    }

	    @DeleteMapping("/students/{id}")
	    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") int studentId) throws ResourceNotFoundException {
	        Student note = studentRepository.findById(studentId)
	                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this Id"+studentId));

	        studentRepository.delete(note);

	        return ResponseEntity.ok().build();
	    }
	}



