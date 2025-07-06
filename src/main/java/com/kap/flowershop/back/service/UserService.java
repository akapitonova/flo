package com.kap.flowershop.back.service;

import com.kap.flowershop.back.entity.Users;
import com.kap.flowershop.front.dto.UserDto;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

	List<Users> getAllUsers();
	
	void deleteUser(String userId);

	void addUser(Users users);
	
	Users getUserById(String userId);

	Users getUserByUsername(String username);

	void updateUser(Users user);

	void updateUserBalance(String username, BigDecimal summ);

	Users updateUserInfo(String userName, UserDto userDto);

	void updateDiscountForUser(long userId, int discount);
}
