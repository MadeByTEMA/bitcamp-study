package com.bitcamp.date;

import java.sql.Date;
import java.util.Scanner;

public class seoulStore {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("가게명을 입력해주세요.");
    String shop = keyboard.nextLine();

    System.out.println("방문일시를 입력해주세요.");
    Date visitDate = Date.valueOf(keyboard.nextLine());

    System.out.println("제목을 입력해주세요.");
    String title = keyboard.nextLine();
    
    System.out.println("내용을 입력해주세요.");
    String content = keyboard.nextLine();
    
    System.out.println("주소를 입력해주세요.");
    String address = keyboard.nextLine();

    System.out.println("가격을 입력해주세요.");
    String price = keyboard.nextLine();
    
    System.out.println("별점을 입력해주세요.");
    String star = keyboard.nextLine();

    Date today = new Date(System.currentTimeMillis());
    
    keyboard.close();
    
    System.out.printf("가게명 : %s\n", shop);
    System.out.printf("등록일시 : %1$tY-%1$tm-%1$tD\n", today);
    System.out.printf("방문일시 : %s\n", visitDate);
    System.out.printf("제목 : %s\n", title);
    System.out.printf("내용 : %s\n", content);
    System.out.printf("주소 : %s\n", address);
    System.out.printf("가격 : %s\n", price);
    System.out.printf("별점 : %s\n", star);

  }
}