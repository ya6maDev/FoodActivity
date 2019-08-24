package com.FoodActivity.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/api/auth")
public class LoginController {

  @Autowired
  private UserService userService;

  @CrossOrigin
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<User> login(@RequestBody User user) {
    return ResponseEntity.ok(userService.findByEmail(user.getEmail()));
  }

  @CrossOrigin
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ResponseEntity<User> findByEmail() {
    return ResponseEntity.ok(userService.findByEmail("test@gmail.com"));
  }
}
