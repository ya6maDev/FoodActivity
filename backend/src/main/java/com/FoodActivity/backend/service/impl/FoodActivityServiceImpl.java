package com.FoodActivity.backend.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FoodActivity.backend.model.FoodActivity;
import com.FoodActivity.backend.repository.FoodActivityRepository;
import com.FoodActivity.backend.service.FoodActivityService;

/**
 * FoodActivity サービス 実装
 *
 * @author y5a1m5a
 *
 */
@Service
public class FoodActivityServiceImpl implements FoodActivityService {

  @Autowired
  private FoodActivityRepository foodActivityRepository;

  @Override
  public List<FoodActivity> findAll() {
    return foodActivityRepository.findAll();
  }

}
