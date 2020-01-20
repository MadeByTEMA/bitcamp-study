// 상수 코드를 별도의 클래스로 분리하여 다루기
package com.eomcs.oop.ex11.c.step5;

public class Exam0110 {
  public static void main(String[] args) {
    Product p = new Product();
    p.category = Category.APPLIANCE_TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p.category = Category.COMPUTER_RAM; // 컴퓨터 / RAM
    p.name = "삼성모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = Category.BOOK_NOVEL; // <== 잘못된 값을 넣을 수 없다!
    p.name = "토지";
    p.price = 18000;
  }
}
