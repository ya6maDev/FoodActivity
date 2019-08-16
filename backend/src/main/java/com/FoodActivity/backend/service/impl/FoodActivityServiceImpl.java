package com.FoodActivity.backend.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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

  @Override
  public Optional<FoodActivity> findById(Long id) {
    return foodActivityRepository.findById(id);
  }

  @Override
  public List<FoodActivity> findByUserId(Long userId) {
    return foodActivityRepository.findByUserId(userId);
  }

  @Override
  public FoodActivity insert(FoodActivity foodActivity) {
    foodActivity.setInsertUser("system");
    foodActivity.setInsertDate(new Date());
    foodActivity.setUpdateUser("system");
    foodActivity.setUpdateDate(new Date());
    return foodActivityRepository.save(foodActivity);
  }

  @Override
  public FoodActivity update(FoodActivity foodActivity) {
    foodActivity.setUpdateUser("system");
    foodActivity.setUpdateDate(new Date());
    return foodActivityRepository.save(foodActivity);
  }

  @Override
  public void delete(long id) {
    foodActivityRepository.deleteById(id);
  }


}
