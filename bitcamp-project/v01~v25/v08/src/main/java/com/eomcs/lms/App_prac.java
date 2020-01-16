package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App_prac {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    class Lesson {
      int no;
      String title;
      String description;
      Date startDate;
      Date endDate;
      int totalHours;
      int dayHours;
    }
    
    String command;
    
    final int LESSON_SIZE = 100;
    
    Lesson[] lessons = new Lesson[LESSON_SIZE];
    
    do {
      System.out.print("명령>");
      command = keyboard.next();
      switch (command) {
        case "/lesson/add":
          for(int i = 1; i < LESSON_SIZE; i++) {
          Lesson lesson = lessons[i];
          
          System.out.println("번호? ");
          lesson.no = keyboard.nextInt();
          
          System.out.println("수업명? ");
          System.out.println("설명? ");
          System.out.println("시작일? ");
          System.out.println("종료일? ");
          System.out.println("총수업시간? ");
          System.out.println("일수업시간? ");
          }
          break;
        case "/lesson/list":
          break;
        case "/member/add":
          break;
        case "/member/list":
          break;
        case "/board/add":
          break;
        case "/board/list":
          break;
        default:
            if(!command.equalsIgnoreCase("quit")) {
                System.out.println("실행할 수 없는 명령입니다.");
            }
      }
    } while(!command.equalsIgnoreCase("quit"));
    System.out.println("안녕");

    keyboard.close();
  }
}
