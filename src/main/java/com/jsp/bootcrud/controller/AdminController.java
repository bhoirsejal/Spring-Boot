package com.jsp.bootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bootcrud.dto.Admin;
import com.jsp.bootcrud.dto.Login;
import com.jsp.bootcrud.dto.ResponseStructure;
import com.jsp.bootcrud.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admins")
	public ResponseStructure<Admin> saveAdmin(@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}
	@GetMapping("/admins/{id}")
	public ResponseStructure<Admin> getAdminById(@PathVariable int id) {
		return adminService.getAdminById(id);
	}
	
	@GetMapping("/admins")
	public ResponseStructure<List<Admin>> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	@PostMapping("/login")
	public ResponseStructure<Admin> validateAdmin(@RequestBody Login login){
		return adminService.validateAdmin(login.getEmail(), login.getPassword());
		
	}
	
	@DeleteMapping("/admin/{id}")
	public ResponseStructure<String> deleteAdmin(@PathVariable int id){
		return adminService.deleteAdmin(id);
		
	}
	@PutMapping("/admin/{id}")
	public ResponseStructure<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin admin){
		return adminService.updateAdmin(id, admin);
	}

}
