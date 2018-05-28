package com.greenspace;

import com.greenspace.model.AuthPermission;
import com.greenspace.model.AuthRole;
import com.greenspace.model.User;
import com.greenspace.service.IAuthUserService;
import com.greenspace.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthUserTests {

	@Autowired
	private IAuthUserService iAuthUserService;

	@Test
	public void getUserRoleListByUserId() {
		List<AuthRole> res =  iAuthUserService.getUserRoleListByUserId(1L);
		System.out.println(res);
	}

	@Test
	public void getUserPermissionByUserId() {
		List<AuthPermission> res =  iAuthUserService.getUserPermissionByUserId(1L);
		System.out.println(res);
	}

}
