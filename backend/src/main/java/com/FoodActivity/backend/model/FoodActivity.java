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

  /** 名前 */
  private String name;

  /** 説明 */
  private String description;

  /**
   * コンストラクタ
   */
  public FoodActivity() {

  }

  /**
   * コンストラクタ
   *
   * @param name
   * @param description
   * @param photo
   */
  public FoodActivity(Long userId, String name, String description) {
    super();
    this.userId = userId;
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return "FoodActivity [id=" + id + ", userId=" + userId + ", name=" + name + ", description="
        + description + "]";
  }
}
