package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.*;


public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    // Handler의 메서드를 사용하기 전에
    // 그 메서드가 작업할 때 사용할 키보드 객체를 설정해줘야한다.
    
    // BoardHandler의 메서드가 사용할 메모리만 게시판 마다 따로 생성한다.
    BoardHandler boardHandler1 = new BoardHandler(keyboard);
    BoardHandler boardHandler2 = new BoardHandler(keyboard, 200);
    BoardHandler boardHandler3 = new BoardHandler(keyboard, 1000);
    BoardHandler boardHandler4 = new BoardHandler(keyboard);
    BoardHandler boardHandler5 = new BoardHandler(keyboard, 9000);
    BoardHandler boardHandler6 = new BoardHandler(keyboard, 20000);
    
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
          
        case "/member/add":
          memberHandler.addMember();
          break;
          
        case "/member/list":
          memberHandler.listMember();
          break;
          
        case "/board/add":
          boardHandler1.addBoard();
          break;
          
        case "/board/list":
          boardHandler1.listBoard();
          break;
          
        case "/board/detail":
          boardHandler1.detailBoard();
          break;
          
        case "/board2/add":
          boardHandler2.addBoard();
          break;
          
        case "/board2/list":
          boardHandler2.listBoard();
          break;
          
        case "/board2/detail":
          boardHandler2.detailBoard();
          break;
          
        case "/board3/add":
          boardHandler3.addBoard();
          break;
          
        case "/board3/list":
          boardHandler3.listBoard();
          break;
          
        case "/board3/detail":
          boardHandler3.detailBoard();
          break;
          
        case "/board4/add":
          boardHandler4.addBoard();
          break;
          
        case "/board4/list":
          boardHandler4.listBoard();
          break;
          
        case "/board4/detail":
          boardHandler4.detailBoard();
          break;
          
        case "/board5/add":
          boardHandler5.addBoard();
          break;
          
        case "/board5/list":
          boardHandler5.listBoard();
          break;
          
        case "/board5/detail":
          boardHandler5.detailBoard();
          break;
          
        case "/board6/add":
          boardHandler6.addBoard();
          break;
          
        case "/board6/list":
          boardHandler6.listBoard();
          break;
          
        case "/board6/detail":
          boardHandler6.detailBoard();
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






