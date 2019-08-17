package com.FoodActivity.backend.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import com.FoodActivity.backend.model.FoodActivity;

/**
 * FoodActivity サービス
 *
 * @author y5a1m5a
 *
 */
public interface FoodActivityService {

  /** 全件検索 */
  public abstract List<FoodActivity> findAll(Sort sort);

  /**
   * Idをキーとして検索
   *
   * @param id ID
   * @return FoodActivity
   */
  public abstract Optional<FoodActivity> findById(Long id);

  /**
   * ユーザーIDをキーとして検索
   *
   * @param userId ユーザーID
   * @return FoodActivityリスト
   */
  public abstract List<FoodActivity> findByUserId(Long userId);

  /**
   * 新規登録
   *
   * @param foodActivity 登録するFoodActivity
   * @return 登録したFoodActivity
   */
  public abstract FoodActivity insert(FoodActivity foodActivity);

  /**
   * 更新
   *
   * @param foodActivity 更新するFoodActivity
   * @return 更新したFoodActivity
   */
  public abstract FoodActivity update(FoodActivity foodActivity);

  /**
   * 削除
   *
   * @param id 削除するFoodActivityのID
   */
  public abstract void delete(long id);
}
