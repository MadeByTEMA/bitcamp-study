package com.eomcs.basic.ex06.assignment;

import java.util.Scanner;

public class Console {
    
  @Deprecated
  static int inputInt() {
    return inputInt("밑변길이는 ?");
  }
    
  static int inputInt(String message) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print(message);
    int width = keyScan.nextInt();
    keyScan.close();
    return width;    
  }
}
