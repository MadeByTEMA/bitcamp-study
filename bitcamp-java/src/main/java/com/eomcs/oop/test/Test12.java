package com.eomcs.oop.test;

// gym 회원 정보를 입력 받아 출력
public class Test12 {
  public static void main(String[] args) {
    
    class Member {
    int no;
    String name;
    int birthYear;
    char gender;
    float height;
    float weight;
    boolean personalTraining;
    }
    
    Member[] arr = new Member[3000];
    // 주의!
    // => Member 인스턴스 주소를 담을 레퍼런스 변수를 3000개 만든다.
    // => Member 인스턴스를 3000개 만드는게 아니다.
    
    // arr[0].no = 100; // runetime 오류!
    
    int count = 0;
    while (count < 3000) {
      arr[count] = new Member();
      count++;
    }
    
    arr[0].no = 100; // OK! 
    // 위 arr[0].no는 runtime 오류고, 밑에는 OK 인 이유는 ?
    // 위에는 레퍼런스를 3000개 만든 것이고
    // 밑에는 레퍼런스를 사용하겠다고 선언한 것이라
    
    
    // 강사님, 배열 문법을 이용하여 인스턴스 3000개 만드는 방법은 없나요 ?
    // => 없다!
    
  }
}
