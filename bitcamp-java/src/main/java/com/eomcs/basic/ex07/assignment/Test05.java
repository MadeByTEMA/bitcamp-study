package com.eomcs.basic.ex07.assignment;

import java.util.Scanner;

// 과제: 재귀호출을 이용하여 직삼각형을 출력하라.
// 실행)
// 밑변의 길이? 5
// *
// **
// ***
// ****
// *****
//
public class Test05 {
  public static void main(String[] args) {
    // 사용자로부터 밑변의 길이를 입력 받는다.
    Scanner keyboard = new Scanner(System.in);
    System.out.println("밑변의 길이? ");
    int base = keyboard.nextInt();
    int temp = base;
    // 직삼각형을 출력한다.
    printTriangle(base, temp);
  }

  static int printTriangle(int base, int temp) {
    // 코드를 완성하시오!
    if(base == 0)
      return 0;
    for(int i = base; i <= temp; i++) {
      System.out.print("*");
    }
    System.out.println();
    return base + printTriangle(base-1, temp); 
  }
}




