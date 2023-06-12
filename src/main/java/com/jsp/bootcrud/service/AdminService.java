package com.jsp.bootcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.bootcrud.dao.AdminDao;
import com.jsp.bootcrud.dto.Admin;
import com.jsp.bootcrud.dto.ResponseStructure;
import com.jsp.exception.InvalidCredentialException;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	//save
	public ResponseStructure<Admin> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
		if(admin != null) {
			responseStructure.setData(adminDao.saveAdmin(admin));
			responseStructure.setMessage("Admin saved successfully");
			responseStructure.setStatusecode(HttpStatus.CREATED.value());
			
		}else {
			responseStructure.setData(null);
			responseStructure.setMessage("Not saved ");
			responseStructure.setStatusecode(404);
		}
		return responseStructure;
	}
	//getById
	public ResponseStructure<Admin> getAdminById(int id) {
		ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
		if(id>0) {
			responseStructure.setData(adminDao.getAdminById(id));
			responseStructure.setMessage("Below is your admin");
			responseStructure.setStatusecode(HttpStatus.ACCEPTED.value());
		}
		else {
			responseStructure.setData(null);
			responseStructure.setMessage("ID Not found");
			responseStructure.setStatusecode(404);
		}
		return responseStructure;
	}
	//getAll
	public ResponseStructure<List<Admin>> getAllAdmins(){
		ResponseStructure<List<Admin>> responseStructure=new ResponseStructure<>();
		List<Admin> admins=adminDao.getAllAdmins();
		if(admins != null) {
			responseStructure.setData(admins);
			responseStructure.setMessage("Complete data found");
			responseStructure.setStatusecode(HttpStatus.CREATED.value());
		}
		else {
			responseStructure.setData(null);
			responseStructure.setMessage("Admins list Not found");
			responseStructure.setStatusecode(404);
		}
		return responseStructure;
	}
	//validate
	public ResponseStructure<Admin> validateAdmin(String email,String password){
		ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
		Admin admin=adminDao.validateAdmin(email, password);
		if(admin != null) {
			responseStructure.setData(admin);
			responseStructure.setMessage("Validate Admin Found");
			responseStructure.setStatusecode(HttpStatus.CREATED.value());
			
		}else {
//			responseStructure.setData(null);
//			responseStructure.setMessage("Admins not detected");
//			responseStructure.setStatusecode(404);
			
			throw new InvalidCredentialException();
		}
		return responseStructure;
	}
	
	//delete
	public ResponseStructure<String> deleteAdmin(int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<>();
		boolean b=adminDao.deleteAdmin(id);
		if(b) {
			responseStructure.setData("Data is deleted");
			responseStructure.setMessage("Admin Deleted");
			responseStructure.setStatusecode(HttpStatus.CREATED.value());
			
		}
		else {
			responseStructure.setData(null);
			responseStructure.setMessage("Not Deleted");
			responseStructure.setStatusecode(404);
		}
		return responseStructure;
	}
	
	//update
	public ResponseStructure<Admin> updateAdmin(int id, Admin admin){
		ResponseStructure<Admin> responseStructure=new ResponseStructure<>();
		Admin admin2  =adminDao.updateAdmin(id, admin);
		if(admin2 != null) {
			responseStructure.setData(admin2);
			responseStructure.setStatusecode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Data is updated");
		}
		else {
			responseStructure.setData(null);
			responseStructure.setStatusecode(404);
			responseStructure.setMessage("Data is not updated");
		}
		return responseStructure;
	}

}
