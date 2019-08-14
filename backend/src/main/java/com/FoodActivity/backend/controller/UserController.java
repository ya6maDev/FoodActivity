package com.FoodActivity.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.FoodActivity.backend.model.User;
import com.FoodActivity.backend.service.UserService;

/**
 * ユーザー コントローラー
 *
 * @author y5a1m5a
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

  /** ユーザー サービス */
  @Autowired
  private UserService userService;

  /**
   * 全件検索する。
   *
   * @return ユーザーリスト
   */
  @CrossOrigin
  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<List<User>> index() {
    return ResponseEntity.ok(userService.findAll());
  }

  /**
   * ユーザー情報を新規登録する。
   *
   * @param user ユーザー
   * @return ユーザー
   */
  @CrossOrigin
  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<User> insert(@RequestBody User user) {
    return ResponseEntity.ok(userService.insert(user));
  }

  /**
   * ユーザー情報を更新する。
   *
   * @param user ユーザー
   * @return ユーザー
   */
  @CrossOrigin
  @RequestMapping(value = "/", method = RequestMethod.PUT)
  @ResponseBody
  public ResponseEntity<User> update(@RequestBody User user) {
    return ResponseEntity.ok(userService.update(user));
  }

  /**
   * ユーザー情報を削除する。
   *
   * @param id ID
   */
  @CrossOrigin
  @RequestMapping(value = "/", method = RequestMethod.DELETE)
  @ResponseBody
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(long id) {
    userService.delete(id);
  }
}
