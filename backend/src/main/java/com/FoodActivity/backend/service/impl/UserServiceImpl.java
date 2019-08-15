package com.FoodActivity.backend.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FoodActivity.backend.model.User;
import com.FoodActivity.backend.repository.UserRepository;
import com.FoodActivity.backend.service.UserService;

/**
 * ユーザー サービス 実装
 *
 * @author y5a1m5a
 *
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> findByUserId(Long userId) {
    return userRepository.findById(userId);
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public User insert(User user) {
    user.setInsertUser("system");
    user.setInsertDate(new Date());
    user.setUpdateUser("system");
    user.setUpdateDate(new Date());
    return userRepository.save(user);
  }

  @Override
  public User update(User user) {
    user.setUpdateUser("system");
    user.setUpdateDate(new Date());
    return userRepository.save(user);
  }

  @Override
  public void delete(long id) {
    userRepository.deleteById(id);
  }
}
