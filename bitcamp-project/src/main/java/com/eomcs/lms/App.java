package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.*;


public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    // Handler의 메서드를 사용하기 전에
    // 그 메서드가 작업할 때 사용할 키보드 객체를 설정해줘야한다.

    // BoardHandler의 메서드가 사용할 메모리만 게시판 마다 따로 생성한다.
    BoardHandler boardHandler = new BoardHandler(keyboard);
    LessonHandler lessonHandler = new LessonHandler(keyboard);
    MemberHandler memberHandler = new MemberHandler(keyboard); 

    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/lesson/add":

          // 다른 클래스로 분리한 메서드를 호출할 때는
          // 클래스를 이름으로 지정해야 한다.
          lessonHandler.addLesson();
          break;
        case "/lesson/list":
          lessonHandler.listLesson();
          break;

        case "/lesson/detail":
          lessonHandler.detailLesson();
          break;

        case "/lesson/update":
          lessonHandler.updateLesson();
          break;

        case "/lesson/delete":
          lessonHandler.deleteLesson();
          break;

        case "/member/add":
          memberHandler.addMember();
          break;

        case "/member/list":
          memberHandler.listMember();
          break;

        case "/member/detail":
          memberHandler.detailMember();
          break;

        case "/member/update":
          memberHandler.updateMember();
          break;

        case "/member/delete":
          memberHandler.deleteMember();
          break;

        case "/board/add":
          boardHandler.addBoard();
          break;

        case "/board/list":
          boardHandler.listBoard();
          break;

        case "/board/detail":
          boardHandler.detailBoard();
          break;

        case "/board/update":
          boardHandler.updateBoard();
          break;

        case "/board/delete":
          boardHandler.deleteBoard();
          break;

        default:
          if (!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      }

    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();
  }
}






