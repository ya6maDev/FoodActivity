package com.FoodActivity.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.FoodActivity.backend.model.common.CommonColumn;
import lombok.Getter;
import lombok.Setter;

/**
 * ユーザー テーブル
 *
 * @author y5a1m5a
 *
 */
@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User extends CommonColumn {

  /** USER_ID */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long userId;

  /** 名前 */
  @Column(name = "user_name")
  private String userName;

  /** Eメール */
  private String email;

  /** パスワード */
  private String password;

  /**
   * コンストラクタ
   */
  public User() {

  }

  /**
   * コンストラクタ
   *
   * @param userName
   * @param email
   * @param password
   */
  public User(String userName, String email, String password) {
    super();
    this.userName = userName;
    this.email = email;
    this.password = password;
  }

  @Override
  public String toString() {
    return "User [userId=" + userId + ", userName=" + userName + ", email=" + email + ", password="
        + password + "]";
  }
}
