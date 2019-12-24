package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.*;


public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    // Handler의 메서드를 사용하기 전에
    // 그 메서드가 작업할 때 사용할 키보드 객체를 설정해줘야한다.
    LessonHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    
    // BoardHandler의 메서드가 사용할 메모리만 게시판 마다 따로 생성한다.
    BoardHandler boardHandler1 = new BoardHandler();
    BoardHandler boardHandler2 = new BoardHandler();
    BoardHandler boardHandler3 = new BoardHandler();
    BoardHandler boardHandler4 = new BoardHandler();
    BoardHandler boardHandler5 = new BoardHandler();
    BoardHandler boardHandler6 = new BoardHandler();
    
    LessonHandler lessonHandler = new LessonHandler();
    MemberHandler memberHandler = new MemberHandler(); 
    
    
    
    String command;

    do {
      System.out.print("\n명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/lesson/add":
          // 다른 클래스로 분리한 메서드를 호출할 때는
          // 클래스를 이름으로 지정해야 한다.
          LessonHandler.addLesson(lessonHandler);
          break;
        case "/lesson/list":
          LessonHandler.listLesson(lessonHandler);
          break;
          
        case "/member/add":
          MemberHandler.addMember(memberHandler);
          break;
          
        case "/member/list":
          MemberHandler.listMember(memberHandler);
          break;
          
        case "/board/add":
          BoardHandler.addBoard(boardHandler1);
          break;
          
        case "/board/list":
          BoardHandler.listBoard(boardHandler1);
          break;
          
        case "/board/detail":
          BoardHandler.detailBoard(boardHandler1);
          break;
          
        case "/board2/add":
          BoardHandler.addBoard(boardHandler2);
          break;
          
        case "/board2/list":
          BoardHandler.listBoard(boardHandler2);
          break;
          
        case "/board2/detail":
          BoardHandler.detailBoard(boardHandler3);
          break;
          
        case "/board3/add":
          BoardHandler.addBoard(boardHandler3);
          break;
          
        case "/board3/list":
          BoardHandler.listBoard(boardHandler3);
          break;
          
        case "/board3/detail":
          BoardHandler.detailBoard(boardHandler3);
          break;
          
        case "/board4/add":
          BoardHandler.addBoard(boardHandler4);
          break;
          
        case "/board4/list":
          BoardHandler.listBoard(boardHandler4);
          break;
          
        case "/board4/detail":
          BoardHandler.detailBoard(boardHandler4);
          break;
          
        case "/board5/add":
          BoardHandler.addBoard(boardHandler5);
          break;
          
        case "/board5/list":
          BoardHandler.listBoard(boardHandler5);
          break;
          
        case "/board5/detail":
          BoardHandler.detailBoard(boardHandler5);
          break;
          
        case "/board6/add":
          BoardHandler.addBoard(boardHandler6);
          break;
          
        case "/board6/list":
          BoardHandler.listBoard(boardHandler6);
          break;
          
        case "/board6/detail":
          BoardHandler.detailBoard(boardHandler6);
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






