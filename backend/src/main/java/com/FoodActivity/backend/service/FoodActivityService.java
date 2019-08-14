package com.FoodActivity.backend.service;

import java.util.List;
import com.FoodActivity.backend.model.FoodActivity;

/**
 * FoodActivity サービス
 *
 * @author y5a1m5a
 *
 */
public interface FoodActivityService {

  /** 全件検索 */
  public abstract List<FoodActivity> findAll();
}
