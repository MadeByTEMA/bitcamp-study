package com.eomcs.basic.tesk1217;


import java.util.Scanner;
public class Test02 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.println("밑변 길이? ");

    int len = keyScan.nextInt();
    
    int line = 1;
    while(line <= 2 * len - 1) {
      if(line <= len) {
        int up = 0;
        String stars = "";
        while(up < line) {
          stars += "*";
          up++;
        }
        System.out.println(stars);
      } else {
        int down = line;
        String stars = "";
        while(down <= 2 * len - 1) {
          stars += "*";
          down++;
        }
        System.out.println(stars);
      }
      line++;
    }
  }
}
