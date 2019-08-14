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

  /**
   * 全件検索
   *
   * @return ユーザーリスト
   */
  public abstract List<User> findAll();

  /**
   * Eメールをキーとして検索
   *
   * @param email Eメール
   * @return ユーザー
   */
  public abstract User findByEmail(String email);

  /**
   * 新規登録
   *
   * @param user 登録するユーザー
   * @return 登録したユーザー
   */
  public User insert(User user);

  /**
   * 更新
   *
   * @param user 更新するユーザー
   * @return 更新したユーザー
   */
  public User update(User user);

  /**
   * 更新
   *
   * @param user 更新するユーザー
   * @return 更新したユーザー
   */
  public void delete(long id);
}
