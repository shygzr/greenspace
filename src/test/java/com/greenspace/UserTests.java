package com.greenspace;

import com.greenspace.dao.UserMapper;
import com.greenspace.model.User;
import com.greenspace.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

	@Autowired
	private IUserService userService;

	@Test
	public void selectByUserName() {
		Optional<User> user = userService.selectByUserName("何琦2");
		System.out.println(user);

	}

	@Test
	public void exitUserName() {
		System.out.println(userService.existUserName("何琦1"));
	}

	@Test
	public void insertUser(){
		User user = new User();
		user.setUserName("何琦2");
		user.setPassword("123");
		userService.insertUser(user);
	}
}
