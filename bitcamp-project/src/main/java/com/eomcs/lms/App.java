package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {
  static final int size = 5;
  static ContentsOfClass[] ofClasses = new ContentsOfClass[size];
  static int count = 0;

  public static void main(String[] args) {
    // 키보드에서 사용자가 입력한 값을 읽어 문자열이나 정수, 부동소수점 등으로 리턴하는 역할.

    inputBoards();

    System.out.println();

    printBoards();

  }

  static void inputBoards() {
    Scanner keyboard = new Scanner(System.in);
    String response;

    for (int i = 0; i < size; i++) {
      ContentsOfClass c = new ContentsOfClass();

      System.out.print("번호? ");
      c.no = keyboard.nextInt();
      keyboard.nextLine(); // nextInt() 후에 남아 있는 줄바꿈 기호를 제거한다.

      System.out.print("수업명? ");
      c.title = keyboard.nextLine();

      System.out.print("설명? ");
      c.description = keyboard.nextLine();

      System.out.print("시작일? ");
      // "YYYY-MM-DD" 형태로 입력된 문자열을 날짜 정보로 바꾼다.
      c.startDate = Date.valueOf(keyboard.next());

      System.out.print("종료일? ");
      c.endDate = Date.valueOf(keyboard.next());

      System.out.print("총수업시간? ");
      c.totalHours = keyboard.nextInt();

      System.out.print("일수업시간? ");
      c.dayHours = keyboard.nextInt();

      ofClasses[i] = c;

      count++;

      keyboard.nextLine();
      System.out.println();

      System.out.print("계속 입력하시겠습니까 ? Y/N ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }
    keyboard.close();
  }

  static void printBoards() {
    for (int i = 0; i < count; i++) {
      ContentsOfClass c = ofClasses[i];

      System.out.printf("%d, %s , %s ~ %s, %d\n", c.no, c.title, c.startDate, c.endDate, c.totalHours);
    }

  }
}

