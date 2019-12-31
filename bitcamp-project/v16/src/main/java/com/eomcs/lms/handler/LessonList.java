package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;

public class LessonList {

  static final int DEFAULT_CAPACITY = 100;
  Lesson[] list;
  int size;

  public LessonList() {
    this.list = new Lesson[DEFAULT_CAPACITY];
  }

  public void add(Lesson lesson) {
    this.list[size++] = lesson;
  }

  public Lesson[] toArray() {
    Lesson[] arr = new Lesson[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.list[i];
      return arr;
    }
    return null;
  }

  public Lesson get(int no) {
    for (int i = 0; i < size; i++) {
      if(this.list[i].getNo() == no)
        return this.list[i];
    }
    return null;
  }
}
