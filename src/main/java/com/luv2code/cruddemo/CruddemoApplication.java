package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
//import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {

//			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO );

			deleteAllStudents(studentDAO);
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO){
		System.out.println("Deleting all students ");
	  int numRowDeleted = studentDAO.deleteAll();
		System.out.println("Numbers of student deleted: " + numRowDeleted);
	}


	private void deleteStudent(StudentDAO studentDAO){

		int studentId = 3;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}



	private void updateStudent(StudentDAO studentDAO){

		int studentId = 1;
		System.out.println("Getting student with id "+ studentId);
		Student myStudent = studentDAO.findById(studentId);


		System.out.println("updating student ...");

		myStudent.setFirstName("John");

		studentDAO.update(myStudent);

		System.out.println("Updated student " + myStudent);




	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){

		List<Student> students =  studentDAO.findByLastName("Duck");

		for(Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}


	private void queryForStudents(StudentDAO studentDAO){


		List<Student> theStudents = studentDAO.findAll();

		for (Student students:theStudents
			 ) {
			System.out.println(students);
		}
	}

	private void readStudent(StudentDAO studentDAO){
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Doe","Duck","DAFFY@MAIL.COM");


		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student " + myStudent);



	}







//	private void createMultipleStudent(StudentDAO studentDAO) {
//
//		System.out.println("creating 3 student objects ...");
//		Student tempStudent1 = new Student("Paul","Doe","paul@email.com");
//		Student tempStudent2 = new Student("Mary","public","paul@email.com");
//		Student tempStudent3 = new Student("Bonita","Applebum","paul@email.com");
//
//		System.out.println("Saving the students ...");
//		studentDAO.save(tempStudent1);
//		studentDAO.save(tempStudent2);
//		studentDAO.save(tempStudent3);
//
//	}


}


