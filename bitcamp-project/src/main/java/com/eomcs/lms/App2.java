package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {
  static final int size = 5;
  static MemberInformation[] memberInfo = new MemberInformation[size];
  static int count = 0;

  public static void main(String[] args) {

    inputBoards();

    System.out.println();

    printBoards();

  }
  static void inputBoards() {
    Scanner keyboard = new Scanner(System.in);
    String response;
    
    for (int i = 0; i < size; i++) {
      MemberInformation m = new MemberInformation();

      System.out.print("번호 ? ");
      m.no = keyboard.nextInt();

      keyboard.nextLine(); // 줄바꿈 기호 제거용

      System.out.print("이름 ? ");
      m.name = keyboard.nextLine();

      System.out.print("이메일 ? ");
      m.email = keyboard.nextLine();

      System.out.print("암호 ? ");
      m.pwd = keyboard.nextLine();

      System.out.print("사진 ? ");
      m.photo = keyboard.nextLine();

      System.out.print("전화 ? ");
      m.tel = keyboard.nextLine();

      m.date = new Date(System.currentTimeMillis());

      memberInfo[i] = m;

      count++;
      System.out.println();

      System.out.print("계속 입력하시겠습니까? (Y/N) ");
      response = keyboard.nextLine();
      if(!response.equalsIgnoreCase("y")) {
        break;
      }
    }
    keyboard.close();
  }

  static void printBoards() {
    for(int i = 0; i < count; i++) {
      MemberInformation m = memberInfo[i];

      System.out.printf("%d, %s ,%s  ,%s, %s\n", m.no, m.name, m.email, m.tel, m.date);
    }
  }
}
