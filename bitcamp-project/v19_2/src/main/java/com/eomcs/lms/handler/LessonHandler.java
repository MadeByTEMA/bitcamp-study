package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  public Scanner input;
  ArrayList<Lesson> lessonList;

  public LessonHandler(Scanner input) {
    this.input = input;
    lessonList = new ArrayList<>();
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(input.nextInt());

    input.nextLine(); 

    System.out.print("수업명? ");
    lesson.setTitle(input.nextLine());

    System.out.print("설명? ");
    lesson.setDescription(input.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(input.next()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(input.next()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(input.nextInt());

    System.out.print("일수업시간? ");
    lesson.setDayHours(input.nextInt());
    input.nextLine(); 


    lessonList.add(lesson);

    System.out.println("저장하였습니다.");
  }

  public void listLesson() {
    Lesson[] arr = this.lessonList.toArray(new Lesson[this.lessonList.size()]);
    for (Lesson l : arr) {
      System.out.printf("%d, %s, %s ~ %s, %d\n",
          l.getNo(), l.getTitle(), l.getStartDate(), l.getEndDate(), l.getTotalHours());
    }
  }

  public void detailLesson() {
    System.out.print("수업 번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfLesson(no);

    if (index == -1) {
      System.out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    Lesson lesson = this.lessonList.get(index);
    
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("수업내용: %s\n", lesson.getDescription());
    System.out.printf("기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
  }

  public void updateLesson() {
    System.out.print("수업 번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfLesson(no);

    if (index == -1) {
      System.out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    Lesson oldLesson = this.lessonList.get(index);

    Lesson newLesson = new Lesson();

    boolean changed = false;

    newLesson.setNo(oldLesson.getNo());

    System.out.printf("수업명(%s)? \n", oldLesson.getTitle());
    newLesson.setTitle(input.nextLine());
    if(newLesson.getTitle().length() == 0) {
      newLesson.setTitle(oldLesson.getTitle());
    } else {
      changed = true;
    }

    System.out.printf("수업내용(%s)? \n", oldLesson.getDescription());
    newLesson.setDescription(input.nextLine());
    if(newLesson.getDescription().length() == 0) {
      newLesson.setDescription(oldLesson.getDescription());
    } else {
      changed = true;
    }

    System.out.printf("시작일(%s)? \n", oldLesson.getStartDate());
    String startDate = input.nextLine();
    if (startDate.length() == 0) {
      newLesson.setStartDate(oldLesson.getStartDate());
    } else {
      newLesson.setStartDate(Date.valueOf(startDate));
      changed = true;
    }

    System.out.printf("종료일(%s)? \n", oldLesson.getEndDate());
    String endDate = input.nextLine();
    if (endDate.length() == 0) {
      newLesson.setEndDate(oldLesson.getEndDate());
    } else {
      newLesson.setEndDate(Date.valueOf(endDate));
      changed = true;
    }

    System.out.printf("총수업시간(%d)? \n", oldLesson.getTotalHours());
    String totalHours = input.nextLine();
    if (totalHours.length() == 0) {
      newLesson.setTotalHours(oldLesson.getTotalHours());
    } else {
      newLesson.setTotalHours(Integer.parseInt(totalHours));
      changed = true;
    }

    System.out.printf("일수업시간(%d)? \n", oldLesson.getDayHours());
    String dayHours = input.nextLine();
    if (dayHours.length() == 0) {
      newLesson.setDayHours(oldLesson.getDayHours());
    } else {
      newLesson.setDayHours(Integer.parseInt(dayHours));
      changed = true;
    }

    if (changed) {
      this.lessonList.set(index, newLesson);
      System.out.println("수업을 변경했습니다.");
    } else {
      System.out.println("수업 변경을 취소하였습니다.");
    }
  }

  public void deleteLesson() {
    System.out.print("수업 번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfLesson(no);

    if (index == -1) {
      System.out.println("해당 번호의 수업이 없습니다.");
      return;
    }

    this.lessonList.remove(index);

    System.out.println("게시글을 삭제했습니다.");
  }
  
  private int indexOfLesson(int no) {
    for (int i = 0; i < this.lessonList.size(); i++) {
      Lesson temp = this.lessonList.get(i);
      if (temp.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
