package com.FoodActivity.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.FoodActivity.backend.model.FoodActivity;
import com.FoodActivity.backend.service.FoodActivityService;

/**
 * FoodActivity コントローラー
 *
 * @author y5a1m5a
 *
 */
@RestController
@RequestMapping("/api/foodActivity")
public class FoodActivityController {

  @Autowired
  private FoodActivityService foodActivityService;

  @CrossOrigin
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<FoodActivity> index() {
    return foodActivityService.findAll();
  }

  @CrossOrigin
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<FoodActivity> findById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(foodActivityService.findById(id).orElse(null));
  }

  /**
   * FoodActivityを新規登録する。
   *
   * @param foodActivity FoodActivity
   * @return FoodActivity
   */
  @CrossOrigin
  @RequestMapping(value = "/", method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<FoodActivity> insert(@RequestBody FoodActivity foodActivity) {
    return ResponseEntity.ok(foodActivityService.insert(foodActivity));
  }

  /**
   * FoodActivityを更新する。
   *
   * @param foodActivity FoodActivity
   * @return foodActivity
   */
  @CrossOrigin
  @RequestMapping(value = "/", method = RequestMethod.PUT)
  @ResponseBody
  public ResponseEntity<FoodActivity> update(@RequestBody FoodActivity foodActivity) {
    return ResponseEntity.ok(foodActivityService.update(foodActivity));
  }

  /**
   * FoodActivityを削除する。
   *
   * @param id ID
   */
  @CrossOrigin
  @RequestMapping(value = "/", method = RequestMethod.DELETE)
  @ResponseBody
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(long id) {
    foodActivityService.delete(id);
  }
}
