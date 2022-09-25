package ryu.assign.database.controller;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import ryu.assign.database.mapper.MybatisUserMapper;
import ryu.assign.database.model.RoleType;
import ryu.assign.database.model.User;

@RestController
@ComponentScan("ryu.assign.database")
public class MybatisController {

	@Autowired
	MybatisUserMapper mybatisUserMapper;
	
	@GetMapping("/mybatis/user/{id}")
	public Optional<User> findUser(@PathVariable long id) {
		return mybatisUserMapper.findUser(id);
	}
	
	@PostMapping("/mybatis/user")
	public void insertUser(User user) {
		user.setRole(RoleType.USER);
		
		mybatisUserMapper.insertUser(user);
	}
	
	@PutMapping("/mybatis/user")
	public void updateUser(User user) {
		mybatisUserMapper.updateUser(user);
	}
	
	@DeleteMapping("/mybatis/user/{id}")
	public void deleteUser(@PathVariable long id) {
		mybatisUserMapper.deleteUser(id);
	}
	
	@GetMapping("/mybatis/userxml/{id}")
	public Optional<User> findUserByXml(@PathVariable long id) {
		return mybatisUserMapper.findUserByXml(id);
	}
	
	@PostMapping("/mybatis/userxml")
	public void insertUserByXml(User user) throws ParseException {
		user.setRole(RoleType.USER);

		mybatisUserMapper.insertUserByXml(user);
	}

	@PutMapping("/mybatis/userxml")
	public void updateUserByXml(User user) {
		mybatisUserMapper.updateUserByXml(user);
	}
	
	@DeleteMapping("/mybatis/userxml/{id}")
	public void deleteUserByXml(@PathVariable long id) {
		mybatisUserMapper.deleteUserByXml(id);
	}
}