package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 { 
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    class MemberInformation {
      int no;
      String name;
      String email;
      String password;
      String photo;
      String tel;
      Date registeredDate;
    }
    
    final int SIZE = 100;
    
    MemberInformation[] members = new MemberInformation[SIZE];
    
    for (int i = 0; i < SIZE; i++) {
      members[i] = new MemberInformation();
    }
    
    
    
    int count = 0;
    
    for (int i = 0; i < SIZE; i++) {
      MemberInformation m = members[i];
      
      System.out.print("번호? ");
      m.no = keyboard.nextInt();
      keyboard.nextLine(); // 줄바꿈 기호 제거용

      System.out.print("이름? ");
      m.name = keyboard.nextLine();

      System.out.print("이메일? ");
      m.email = keyboard.nextLine();

      System.out.print("암호? ");
      m.password = keyboard.nextLine();

      System.out.print("사진? ");
      m.photo = keyboard.nextLine();

      System.out.print("전화? ");
      m.tel = keyboard.nextLine();

      m.registeredDate = new Date(System.currentTimeMillis());
      
      count++;
      
      members[i] = m;
      
      System.out.print("계속 입력하시겠습니까?(Y/n) ");
      String response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y"))
        break;
    }
    keyboard.close();

    System.out.println();

    for (int i = 0; i < count; i++) {
      MemberInformation m = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.no, m.name, m.email, m.tel, m.registeredDate);
    }
  }
}
