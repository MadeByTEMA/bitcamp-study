package com.eomcs.basic.ex03;

// 리터럴(literal) - __
// - 자바 언어에서 값을 표기하는 문법
public class Exam22 {
  public static void main(String[] args) {
    // 10진수 리터럴
    System.out.println(235_000_000);
    System.out.println(2_3500_0000);
    System.out.println(2_35_00_0_00_0);
    // System.out.println(_235_000_000);
    // System.out.println(235_000_000_);

    // 8진수 리터럴
    System.out.println(01_44);
    System.out.println(0_144);
    // System.out.println(_0144);
    // System.out.println(0144_);


    // 2진수
    System.out.println(0b01100100);
    System.out.println(0B01100100);
    // System.out.println(0B_01100100);
    // System.out.println(0B01100100_);
    // System.out.println(_0B01100100);

    //16진수
    System.out.println(0x64);
    System.out.println(0X0064);
    // System.out.println(0X_0064);
    // System.out.println(0X0064_);
    // System.out.println(_0X0064);
  }
}