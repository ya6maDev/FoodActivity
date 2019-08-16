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

@Entity
@Table(name = "FOOD_ACTIVITY")
@Getter
@Setter
public class FoodActivity extends CommonColumn {

  /** ID */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** ユーザーID */
  @Column(name = "user_id")
  private Long userId;

  /** タイトル */
  private String title;

  /** つぶやき */
  private String tweet;

  /**
   * コンストラクタ
   */
  public FoodActivity() {

  }

  /**
   * コンストラクタ
   *
   * @param title
   * @param description
   * @param photo
   */
  public FoodActivity(Long userId, String title, String tweet) {
    super();
    this.userId = userId;
    this.title = title;
    this.tweet = tweet;
  }

  @Override
  public String toString() {
    return "FoodActivity [id=" + id + ", userId=" + userId + ", title=" + title + ", tweet=" + tweet
        + "]";
  }
}
