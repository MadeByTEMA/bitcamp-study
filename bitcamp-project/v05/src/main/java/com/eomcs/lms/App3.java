package com.eomcs.lms;

import java.util.Scanner;
import java.sql.Date;

public class App3 {
  public static void main(String[] args) {
    // 현재 일시
    // currentTimeMillis()
    // => 1970년 1월 1일 0시 0분 0초부터 현재까지 경과된 시간을
    //    밀리초로 리턴한다.
    // new Date(밀리초)
    // => 넘겨 받은 밀리초를 가지고 년,월,일,시,분,초를 계산한다.
    Scanner keyboard = new Scanner(System.in);
    
    System.out.print("번호 ? ");
    int no = keyboard.nextInt();
    
    keyboard.nextLine();
    
    System.out.print("내용 ? ");
    String txt = keyboard.nextLine();
    
    Date today = new Date(System.currentTimeMillis());
    int count = 0;
    
    System.out.println();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("내용: %s\n", txt);
    System.out.printf("작성일: %1$tY-%1$tm-%1$td\n", today);
    System.out.printf("조회수: %d", count);
    
    keyboard.close();
  }
}
