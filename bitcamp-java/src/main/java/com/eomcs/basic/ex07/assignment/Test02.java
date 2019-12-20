package com.eomcs.basic.ex07.assignment;

public class Test02 {
  public static void main(String[] args) {
    int[] values = {34, 4, -3, 78, 12, 22, 45, 0, -22};
    sort(values);//오름차순으로 정렬을 수행

    for (int value : values) {
      System.out.println(value);
      //출력결과 : -22, -3, 0, 4, 12, 22, 34, 45, 78
    }
  }
  static void sort(int[] values) {
    int a = 0;
    for (int i = 0; i < values.length; i++) {
      for (int j = 0; j < i; j++) {
        if(values[j] > values[i]) {
          a = values[j];
          values[j] = values[i];
          values[i] = a;
        }
      }
    }
  }
}
