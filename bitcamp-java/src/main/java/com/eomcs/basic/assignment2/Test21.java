// 과제 1 : 가위,바위,보 게임 애플리케이션을 작성하라.
// - 실행1
// 가위,바위,보? 보
// 컴퓨터: 가위 (랜덤 값이 출력된다. 힌트: Math.random())
// => 졌습니다.
//
// - 실행2
// 가위,바위,보? 바위
// 컴퓨터: 가위
// => 이겼습니다.
//
package com.eomcs.basic.assignment2;

import java.util.Scanner;

public class Test21 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("가위,바위,보? ");
    String G = keyboard.nextLine();

    keyboard.close();

    int i = (int) (Math.random() * 3 + 1);

    if ("바위".equals(G) || "가위".equals(G) || "보".equals(G)) {
      if ("바위".equals(G)) {
        if (i == 1) {
          System.out.println("컴퓨터가 가위를 냈습니다. 사용자가 이겼습니다.");
        } else if (i == 2) {
          System.out.println("컴퓨터가 바위를 냈습니다. 사용자가 비겼습니다.");
        } else if (i == 3) {
          System.out.println("컴퓨터가 보를 냈습니다. 사용자가 졌습니다.");
        }
      }
      if ("가위".equals(G)) {
        if (i == 1) {
          System.out.println("컴퓨터가 보를 냈습니다. 사용자가 이겼습니다.");
        } else if (i == 2) {
          System.out.println("컴퓨터가 가위를 냈습니다. 사용자가 비겼습니다.");
        } else if (i == 3) {
          System.out.println("컴퓨터가 바위를 냈습니다. 사용자가 졌습니다.");
        }
      }
      if ("보".equals(G)) {
        if (i == 1) {
          System.out.println("컴퓨터가 바위를 냈습니다. 사용자가 이겼습니다.");
        } else if (i == 2) {
          System.out.println("컴퓨터가 보를 냈습니다. 사용자가 비겼습니다.");
        } else if (i == 3) {
          System.out.println("컴퓨터가 가위를 냈습니다. 사용자가 졌습니다.");
        }
      }
    } else {
      System.out.println("잘못입력하셨습니다.");
    }
  }
}
