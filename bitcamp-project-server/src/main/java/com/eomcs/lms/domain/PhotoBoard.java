package com.eomcs.lms.domain;

import java.io.Serializable;
import java.sql.Date;

public class PhotoBoard implements Serializable {

  private static final long serialVersionUID = 1L;

  int no;
  int lessonNo;
  String title;
  Date createDate;
  int viewCount;

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public int getLessonNo() {
    return lessonNo;
  }

  public void setLessonNo(int lessonNo) {
    this.lessonNo = lessonNo;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
}
