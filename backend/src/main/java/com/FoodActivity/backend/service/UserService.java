package com.FoodActivity.backend.service;

import java.util.List;
import com.FoodActivity.backend.model.User;

/**
 * ユーザー サービス
 *
 * @author y5a1m5a
 *
 */
public interface UserService {

  /** 全件検索 */
  public abstract List<User> findAll();

  /** Eメールをキーとして検索 */
  public abstract User findByEmail(String email);
}
