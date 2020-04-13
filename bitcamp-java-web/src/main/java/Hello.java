
public class Hello {

  { // 인스턴스 블록
    System.out.println("ex06 인스턴스 생성!");
  }

  static { // 스태틱 블록
    System.out.println("ex06 클래스 로딩");
  }

  public static void main(String[] args) {
    int a = 10;
    if (a < 100) {
      System.out.println("okok");
    }
  }

}
