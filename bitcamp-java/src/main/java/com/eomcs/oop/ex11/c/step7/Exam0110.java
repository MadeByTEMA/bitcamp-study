// 상수 코드를 스태틱 중첩 클래스로 다루기
package com.eomcs.oop.ex11.c.step7;

public class Exam0110 {
  public static void main(String[] args) {

    // 카테고리 값을 지정할 때 OGNL 표기법으로 지정한다.
    // OGNL(Object Graph Navigation Language)?
    // => 자바에서 객체 안에 있는 필드를 가리킬 때 점(.)을 이용하여 표기하는 방법.
    // => 객체 안에 객체가 계층적으로 들어 있을 때 파일 경로를 가리키듯
    // 점(.)을 이용하여 가리킬 수 있다.
    // 예) 객체.필드.필드.필드 = 100;

    Product p = new Product();
    p.category = Category.appliance.TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p.category = Category.computer.RAM; // 컴퓨터 / RAM
    p.name = "삼성모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = Category.book.NOVEL; // <== 잘못된 값을 넣을 수 없다!
    p.name = "토지";
    p.price = 18000;
  }
}
