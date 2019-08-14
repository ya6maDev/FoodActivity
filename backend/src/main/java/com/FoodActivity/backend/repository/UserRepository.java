package com.FoodActivity.backend.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.FoodActivity.backend.model.User;

/**
 * ユーザー リポジトリ
 *
 * @author y5a1m5a
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  /** 全件検索 */
  public abstract List<User> findAll();

  /** Eメールをキーとして検索 */
  public abstract User findByEmail(String email);

}
