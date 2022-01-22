package com.example.crudproject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


	private final StudentRepository studentRepository;
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<String> getStudents() {
		List<String> res = new ArrayList<>();
		try {
			Connection conn = Connectivity.dbConnect();
			String sqlQuery = "select * from students";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);

			while(rs.next()) {
				res.add(String.format("Id: %s; Name : %s; Age: %d; Address: %s;", rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return res;
	}

//	public void addNewStudent(Student student) {
//		Optional<Student> studentByName= studentRepository.findStudentByName(student.getName());
//		if(studentByName.isPresent()) {
//			throw new IllegalStateException("name taken");
//		}
//		studentRepository.save(student);
//	}

	public void addNewStudent(Student student) {
		try {
			Connection conn = Connectivity.dbConnect();
			String sqlQuery = "INSERT into students VALUES(?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sqlQuery);
			st.setString(1,"23245");
			st.setString(2, student.getName());
			st.setInt(3,student.getAge());
			st.setString(4, student.getAddress());
			int cnt = st.executeUpdate();

			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	public void deleteStudent(String studentId) {
//		boolean exists = studentRepository.existsById(studentId);
//		if(!exists) {
//			throw new IllegalStateException("student with id:"+studentId+" not present!");
//		}
//		studentRepository.deleteById(studentId);
//	}

	public String deleteStudent(String id) {
		try {
			Connection conn = Connectivity.dbConnect();
			String sqlQuery = "select * from students where id='"+id+"'";
			String deleteQuery = "DELETE FROM students where id='"+id+"'";
			Statement st = conn.createStatement();
			ResultSet rs  = st.executeQuery(sqlQuery);
			String res =  "";
			if(rs.next()) {
				res = String.format("Id: %s; Name : %s; Age: %d; Address: %s;", rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				st.executeUpdate(deleteQuery);
				res += "Record Deleted!";
			}
			else {
				throw new IllegalStateException(
						"student with id " + id + " does not exist"
				);
			}
			st.close();
			conn.close();
			return res;
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}

//	@Transactional
//	//Spring goes in managed phase
//	//Spring Data JPA
//	public void updateStudent(String studentId, String name) {
//		Student student = studentRepository.findById(studentId)
//				.orElseThrow(() -> new IllegalStateException(
//						"student with id " + studentId + " does not exist"
//						));
//		if(name!=null && name.length()>0 && !Objects.equals(student.getName(), name)) {
//			student.setName(name);
//		}
//	}

	@Transactional
	//Spring goes in managed phase
	//Spring Data JPA
	public void updateStudent(String id, String name) {
		try {
			Connection conn = Connectivity.dbConnect();
			String sqlQuery = "select * from students where id='"+id+"'";
			String actionQuery = "UPDATE students SET name='"+name+"' where id='"+id+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			if(rs.next()) {
				st.executeUpdate(actionQuery);
			} else {
				throw new IllegalStateException(
						"student with id " + id + " does not exist"
				);
			}
			st.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getStudentById(String id) {
		try {
			Connection conn = Connectivity.dbConnect();
			String sqlQuery = "select * from students where id='"+id+"'";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			String res =  "";
			if(rs.next()) {
				res = String.format("Id: %s; Name : %s; Age: %d; Address: %s;", rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
			else {
				res =  "Err! Record Not Found!";
			}
			st.close();
			conn.close();
			return res;
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}
}
