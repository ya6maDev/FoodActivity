package com.FoodActivity.backend.model;

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
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

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
  public FoodActivity(String name, String description) {
    super();
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return "FoodActivity [id=" + id + ", name=" + name + ", description=" + description + "]";
  }
}
