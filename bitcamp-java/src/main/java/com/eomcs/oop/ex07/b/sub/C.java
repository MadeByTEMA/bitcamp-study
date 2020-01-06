package com.eomcs.oop.ex07.b.sub;

public class C {
  private int privateVar;
  int defaultVar;
  protected int protectedVar;
  public int publicVar;
  
  C obj3 = new C();

  //obj3.privateVar = 100; // 접근 불가! 오직 그 클래스 안에서만 사용 가능.
  //obj3.defaultVar = 100; // 접근 불가! 같은 패키지까지만 접근 가능.
  //obj3.protectedVar = 100; // 접근 불가! 같은 패키지 또는 자식 클래스 접근 가능
  // 자식 클래스인데 접근 불가?
  // 이유 => 자기의 인스턴스 변수가 아니다.
  obj3.publicVar = 100; // OK! 모두 다 접근 가능.
}
