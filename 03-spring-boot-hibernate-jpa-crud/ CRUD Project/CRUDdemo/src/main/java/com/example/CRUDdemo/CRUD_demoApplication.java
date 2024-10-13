package com.example.CRUDdemo;

import com.example.CRUDdemo.dao.StudentDao;
import com.example.CRUDdemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CRUD_demoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CRUD_demoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			//createStudent(studentDao);
			createMultipleStudents(studentDao);
			//findCertainStudent(studentDao);
			//queryAllStudents(studentDao);
			//getStudentUsingLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudent(studentDao);
		};
	}

	private void deleteStudent(StudentDao studentDao) {
		//1st we retrieve student using primary key
		studentDao.deleteStudent(5);
	}
	private void deleteAllStudent(StudentDao studentDao) {
		//1st we retrieve student using primary key
		studentDao.deleteAllStudent();
	}
	private void updateStudent(StudentDao studentDao) {
		//1st we retrieve student using primary key
		Student student = studentDao.find(1);
		student.setFirst_name("manar");
		studentDao.updateStudent(student);
	}
	private void getStudentUsingLastName(StudentDao studentDao) {
		System.out.println("getting specific student: ");
		System.out.println(studentDao.findStudentByLastName("ayman"));
	}

	private void queryAllStudents(StudentDao studentDao) {
		System.out.println("getting all students");
		for(Student s : studentDao.findAllStudents())
			System.out.println(s);
	}

	private void findCertainStudent(StudentDao studentDao) {
		System.out.println("enter the student id you want to find : ");
		Scanner scanner = new Scanner(System.in);
		Integer id = scanner.nextInt();
		Student student = studentDao.find(id);
		System.out.println("student details:\n");
		System.out.println(student);
	}

	private void createMultipleStudents(StudentDao studentDao) {
		Student s1 = new Student("ahmed", "mohamed", "ahmedmohamed@gmail.com");
		Student s2 = new Student("khalid", "magdy", "khalidMagdy@gmail.com");
		Student s3 = new Student("mariam", "ahmed", "mariamahmed@gmail.com");
		Student s4 = new Student("nour", "mohamed", "nourmohamed@gmail.com");
		Student s5 = new Student("hazem", "ahmed", "hazemahmed@gmail.com");
		List<Student> students = Arrays.asList(s1, s2, s3, s4, s5);
		studentDao.save(s1);
		studentDao.save(s2);
		studentDao.save(s3);
		studentDao.save(s4);
		studentDao.save(s5);
		System.out.println("now 5 students are saved!!");
		for(Student s : students)
			System.out.println("the generated id of " + s.getFirst_name() + " = " + s.getId());
	}

	private static void createStudent(StudentDao studentDao) {
		System.out.println("Creating Student");
		Student student = new Student("zeyad", "ayman", "zeadayman@gmail.com");
		System.out.println("Saving Student to Database");
		studentDao.save(student);
		System.out.println("now the generated id for this student is : " + student.getId());
	}
}

