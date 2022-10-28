package com.jpa.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.Entity.User;
import com.jpa.test.Service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService us;
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return us.getAllUsers();
	}
	@PostMapping("users/adduser")
	public String addUser(@RequestBody User user) {
		us.addUser(user);
		return "user added";
	}
	
	@DeleteMapping("users/delete/{id}")
	public String deleteUser(@PathVariable Integer id) {
		boolean deleted = us.deleteUser(id);
		return deleted ? "user deleted" :  "user with id " +id+" not found";
		
	}
	@PutMapping("users/update/{id}")
	public String updateUser(@RequestBody User user, @PathVariable Integer id) {
		us.updateUser(id,user);
		return "user updated";
	}
	
	
}
