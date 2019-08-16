package com.FoodActivity.backend.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.FoodActivity.backend.model.FoodActivity;

/**
 * FoodActivity リポジトリ
 *
 * @author y5a1m5a
 *
 */
@Repository
public interface FoodActivityRepository extends CrudRepository<FoodActivity, Long> {

  /** 全件検索 */
  public abstract List<FoodActivity> findAll();

  /** ユーザーIDをキーとして、検索 */
  public abstract List<FoodActivity> findByUserId(Long userId);

}
