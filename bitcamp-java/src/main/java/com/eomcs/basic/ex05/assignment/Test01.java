package com.eomcs.basic.tesk1216;

import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("입력 ? ");
    int start = keyboard.nextInt();
    int end = keyboard.nextInt();
    
    int sum = 0;
    for(int no = start; no <= end; no++ ) {
      sum += no;
    }
    System.out.printf("%d에서 %d까지의 합은 %s입니다.", start, end, sum);
    keyboard.close();
  }
}
