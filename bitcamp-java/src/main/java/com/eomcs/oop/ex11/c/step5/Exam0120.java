// 상수 코드를 별도의 클래스로 분리하여 다루기 - static 멤버 import
package com.eomcs.oop.ex11.c.step5;

// 특정 클래스의 스태틱 멤버를 클래스 이름없이 사용하고 싶다면
// 다음과 같이 미리 컴파일러에게 알려줘라.
import static com.eomcs.oop.ex11.c.step5.Category.APPLIANCE_TV;
import static com.eomcs.oop.ex11.c.step5.Category.BOOK_NOVEL;
import static com.eomcs.oop.ex11.c.step5.Category.COMPUTER_RAM;

// 다음과 같이 와일드카드를 사용해도 된다.
// import static com.eomcs.oop.ex11.c.step5.Category.*;

public class Exam0120 {
  public static void main(String[] args) {
    Product p = new Product();
    p.category = APPLIANCE_TV;
    p.name = "울트라비전 뷰";
    p.price = 2000000;

    Product p2 = new Product();
    p.category = COMPUTER_RAM; // 컴퓨터 / RAM
    p.name = "삼성모듈램 4GB";
    p.price = 80000;

    Product p3 = new Product();
    p.category = BOOK_NOVEL; // <== 잘못된 값을 넣을 수 없다!
    p.name = "토지";
    p.price = 18000;
  }
}
