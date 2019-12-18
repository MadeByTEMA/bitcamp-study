package com.eomcs.basic.tesk1217;

import java.util.Scanner;
public class Test03 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("밑변 길이 ?");
    int len = keyScan.nextInt();
    
    int line = 0;
    while (line < len / 2 + 1 ) {
      int j = 0;
      int k = line;
      String blink = "";
      while (k < len / 2) {
        blink += " ";
        k++;
      }
      String stars = "*";
      while (j < line) {
        stars += "**";
        j++;
      }
      System.out.println(blink+stars);
      line++;
    }
  }
}
