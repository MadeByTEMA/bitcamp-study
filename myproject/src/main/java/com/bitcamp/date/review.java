package com.bitcamp.date;

import java.util.Scanner;

public class review {
  static final int size = 100_000;
  static reviewDTO[] reviews = new reviewDTO[size];

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    for(i = 0; i < size; i++) {
    
    
    System.out.println("가게명을 입력해주세요.");
    String storeName = keyboard.nextLine();
    
    System.out.println("메뉴을 입력해주세요.");
    String menu = keyboard.nextLine();
    
    System.out.println("가격을 입력해주세요.");
    String price = keyboard.nextLine();
    
    System.out.println("별점을 입력해주세요.");
    String star = keyboard.nextLine();
    
    System.out.println("주소를 입력해주세요.");
    String address = keyboard.nextLine();
    
    int category = 0;

    }
    keyboard.close();
    
    System.out.printf("가게명 : %s\n", storeName);
    System.out.printf("메뉴 : %s\n", menu);
    System.out.printf("가격 : %s\n", price);
    System.out.printf("별점 : %s\n", star);
    System.out.printf("주소 : %s\n", address);
    System.out.printf("카테고리 : %s\n", category);
  }
}