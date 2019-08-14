package com.FoodActivity.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.FoodActivity.backend.model.User;
import com.FoodActivity.backend.service.UserService;

/**
 * ログインコントローラー
 *
 * @author y5a1m5a
 *
 */
@RestController
@RequestMapping("/api")
public class LoginController {

  @Autowired
  private UserService usersService;

  @CrossOrigin
  @GetMapping("/login")
  public List<User> login() {
    return usersService.findAll();
  }
}
