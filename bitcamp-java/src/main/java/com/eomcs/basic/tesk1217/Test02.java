package com.eomcs.basic.tesk1217;


import java.util.Scanner;
public class Test02 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("밑변 길이? ");
    int width = keyScan.nextInt();
    
    //현재 과제와 유사한 결과를 내는 기존 소스를 가져온다.
    int line = 0;
    while (line++ < width) {
      int x = 1;
      while (x++ <= line) {
        System.out.print("*");
      }
      System.out.println();
    }
    
    line--;
    
    while (--line > 0) {
      int x = 0;
      while (x++ < line ) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
