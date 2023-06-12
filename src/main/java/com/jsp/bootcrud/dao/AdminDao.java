package com.jsp.bootcrud.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bootcrud.dto.Admin;
import com.jsp.bootcrud.repository.AdminRepository;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminRepository adminRepository;
	
	//save
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	//getByid
	public Admin getAdminById(int id) {
		Optional<Admin> opt =adminRepository.findById(id);
		if(opt!=null) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	//getAll
	public List<Admin> getAllAdmins(){
		return adminRepository.findAll();
	}
	
	//validate
	public Admin validateAdmin(String email, String password) {
		return adminRepository.validateAdmin(email, password);
	}
	
	//delete
	public boolean deleteAdmin(int id) {
		Optional<Admin> opt=adminRepository.findById(id);
		if (opt != null) {
			adminRepository.delete(opt.get());
			return true;
			
		}
		else return false;
	}
	//update
	public Admin updateAdmin(int id, Admin admin) {
		Optional<Admin> opt =adminRepository.findById(id);
		if(opt != null) {
		  return adminRepository.save(admin);
		}
		else return null;
	}
	
	

}
