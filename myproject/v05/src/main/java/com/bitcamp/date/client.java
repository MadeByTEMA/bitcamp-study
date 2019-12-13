package com.bitcamp.date;

import java.sql.Date;
import java.util.Scanner;

public class client {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("ID를 입력해주세요.");
    String id = keyboard.nextLine();
    
    System.out.println("PWD를 입력해주세요.");
    String pwd = keyboard.nextLine();
    
    System.out.println("이름을 입력해주세요.");
    String name = keyboard.nextLine();
    
    System.out.println("생년월일을 입력해주세요.");
    Date signUpDate = Date.valueOf(keyboard.nextLine());
    
    System.out.println("성별을 입력해주세요.");
    String sex = keyboard.nextLine();
    
    System.out.println("전화번호를 입력해주세요.");
    String tel = keyboard.nextLine();
    
    System.out.println("주소를 입력해주세요.");
    String address = keyboard.nextLine();
    
    int vip = 0;
    
    java.util.Date today = new java.util.Date();
    
    keyboard.close();
    
    System.out.printf("ID : %s\n", id);
    System.out.printf("PWD : %s\n", pwd);
    System.out.printf("이름 : %s\n", name);
    System.out.printf("생년월일 : %s\n", signUpDate);
    System.out.printf("성별 : %s\n", sex);
    System.out.printf("전화번호 : %s\n", tel);
    System.out.printf("거주지 : %s\n", address);
    System.out.printf("가입일 : %1$tY-%1$tm-%1$td\n", today);
    System.out.printf("등급 : %s\n", vip);
  }
}