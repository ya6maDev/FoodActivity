package com.FoodActivity.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.FoodActivity.backend.model.FoodActivity;
import com.FoodActivity.backend.service.FoodActivityService;

/**
 * ログインコントローラー
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
}
