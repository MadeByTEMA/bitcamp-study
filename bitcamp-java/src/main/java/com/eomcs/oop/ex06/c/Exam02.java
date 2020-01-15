// 오버라이딩(overriding) - 오버라이딩 문법이 없다면?
package com.eomcs.oop.ex06.c;

public class Exam02 {
    public static void main(String[] args) {
        A2 obj1 = new A2();
        obj1.name = "홍길동";
        obj1.age = 20;
        
        obj1.print();
        
        // 아하! 그런데 문제가 있다.
        // A 설계도에 있는 print()는 오직 이름만 출력하게 되어 있다.
        // 이 메서드를 변경해야 하는데, 
        // 기존의 A 클래스를 손대지 않고 print()의 기능을 변경할 순 없을까?
        // 만약 없다면?
        // => 다른 이름으로 메서드를 만들어야겠지!
        // => 왜? 오버로딩에서는 파라미터 형식이 같은 메서드를 중복해서 만들 수 없다!
        // 그래서 A2 클래스에서는 print2()라는 메서드를 추가하였다.
        // 
        obj1.print2();
        
        
        // 부모 클래스로부터 상속 받은 메서드를 재정의할 수 없어서 
        // 새 메서드를 만들어야 한다면,
        // 같은(또는 유사한) 일을 하는 메서드에 대해 
        // 안타깝게도 다른 이름으로 메서드를 만들어야 하기 때문에 
        // 개발자는 여러 개의 메서드를 암기해야 하는 번거로움이 생긴다.
        // => 이런 문제를 해결하기 위해 등장한 문법이 "오버라이딩(overriding)"이다!
        // Exam03.java에서 계속...
    }
}








