package com.FoodActivity.backend.model.common;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * 共通カラム
 *
 * @author y5a1m5a
 *
 */
@MappedSuperclass
@Getter
@Setter
public class CommonColumn {

  /** 登録ユーザー */
  @Column(name = "insert_user")
  private String insertUser;

  /** 登録日時 */
  @Column(name = "insert_date")
  private Date insertDate;

  /** 更新ユーザー */
  @Column(name = "update_user")
  private String updatetUser;

  /** 更新日時 */
  @Column(name = "update_date")
  private Date updateDate;

  /**
   * コンストラクタ
   */
  public CommonColumn() {

  }

  /**
   * コンストラクタ
   *
   * @param insertUser
   * @param insertDate
   * @param updatetUser
   * @param updateDate
   */
  public CommonColumn(String insertUser, Date insertDate, String updatetUser, Date updateDate) {
    super();
    this.insertUser = insertUser;
    this.insertDate = insertDate;
    this.updatetUser = updatetUser;
    this.updateDate = updateDate;
  }

  @Override
  public String toString() {
    return "CommonColumn [insertUser=" + insertUser + ", insertDate=" + insertDate
        + ", updatetUser=" + updatetUser + ", updateDate=" + updateDate + "]";
  }
}
