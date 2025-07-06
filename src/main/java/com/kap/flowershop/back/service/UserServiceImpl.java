package com.kap.flowershop.back.service;

import com.kap.flowershop.back.entity.Users;
import com.kap.flowershop.back.repository.UserRepository;
import com.kap.flowershop.front.dto.UserDto;
import com.kap.flowershop.front.enums.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Users> getAllUsers() {
		List<Users> users = userRepository.findAll();
		log.info("Getted users: " + users);
		return users;
	}

	@Override
	@Transactional
	public void deleteUser(String userId) {
		userRepository.deleteById(Long.parseLong(userId));
	}

	@Override
	@Transactional
	public void addUser(Users user){
		user.getUserProperties().setBalance(new BigDecimal("2000.0"));
		//users.setDiscount(new BigDecimal(3.0));
		user.setRole(Role.USER);
		userRepository.save(user);
		log.info("Added user: "+ user.getUserName());
	}

	@Override
	public Users getUserById(String userId) {
		return userRepository.findById(Long.parseLong(userId)).orElse(null);
	}

	@Override
	public Users getUserByUsername(String username) {
		return userRepository.findByUserName(username).orElse(null);
	}

	@Override
	@Transactional
	public void updateUser(Users user) {
		userRepository.save(user);
	}

	@Override
	public void updateUserBalance(String username, BigDecimal summ) {
		Users user = getUserByUsername(username);
		user.getUserProperties().setBalance(user.getUserProperties().getBalance().add(summ));
		updateUser(user);
	}

	@Override
	public Users updateUserInfo(String userName, UserDto userDto) {
		Users user = getUserByUsername(userName);
		user.getUserProperties().setFirstName(userDto.getFirstName());
		user.getUserProperties().setLastName(userDto.getLastName());
		user.getUserProperties().setCustomerPhone(userDto.getCustomerPhone());
		user.getUserProperties().setShippingAddress(userDto.getShippingAddress());
		updateUser(user);

		return user;
	}

	@Override
	public void updateDiscountForUser(long userId, int discount) {
		Users user = getUserById(String.valueOf(userId));
		user.getUserProperties().setDiscount(new BigDecimal(discount));
		updateUser(user);
	}
}
