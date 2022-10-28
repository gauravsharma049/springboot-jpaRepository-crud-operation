package com.jpa.test.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.Entity.User;
import com.jpa.test.dao.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository ur;
	public List<User> getAllUsers(){
		return ur.findAll();
	}
	
	public void addUser(User user) {
		ur.save(user);
	}
	
	public boolean deleteUser(int id) {
		try {
		User user = ur.getReferenceById(id);
		System.out.println(user);
		ur.delete(user);
		return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void updateUser(int id, User user) {
		User user1 = ur.getReferenceById(id);
		user1.setName(user.getName());
		user1.setAddress(user.getAddress());
		user1.setStatus(user.getStatus());
		ur.save(user1);
		
	}
}
