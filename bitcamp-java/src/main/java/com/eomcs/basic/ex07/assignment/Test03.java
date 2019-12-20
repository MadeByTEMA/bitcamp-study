package com.eomcs.basic.ex07.assignment;

public class Test03 {
  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};

    // 배열에 들어 있는 값의 순서를 거꾸로 바꿔라.
    reverse(values);

    for (int value : values) {
      System.out.println(value);
    }
    // 출력결과 : 
    // -22, 0, 45, 22, 12, 78, -3, 4, 34 
  }
  
  static void reverse(int[] values) {
    for (int i = 0; i < values.length / 2; i++) {
        int j = values[i];
        values[i] = values[values.length- 1 - i ];
        values[values.length - 1 - i] = j;
    }
  }
}
