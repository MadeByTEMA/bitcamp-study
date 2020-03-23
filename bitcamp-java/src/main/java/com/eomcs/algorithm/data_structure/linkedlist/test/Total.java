package com.eomcs.algorithm.data_structure.linkedlist.test;

import java.lang.reflect.Array;

public class Total<T, E> {
  Day<T, E> firstDay;
  E value;
  Day<T, E> lastDay;
  int size;

  public void add(E value) {
    Day<T, E> newDay = new Day<>();
    newDay.value = value;

    if (firstDay == null) {
      firstDay = lastDay = newDay;
    } else {
      lastDay.nextDay = newDay;
      lastDay = newDay;
    }

    this.size++;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    Day<T, E> cursor = firstDay;
    for (int i = 0; i < index; i++) {
      cursor = cursor.nextDay;
    }

    return cursor.value;
  }

  public void add(int index, E value) {
    if (index < 0 || index >= size) {
      return;
    }

    Day<T, E> newDay = new Day<>();
    newDay.value = value;

    Day<T, E> cursor = firstDay;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.nextDay;
    }

    if (index == 0) {
      newDay.nextDay = firstDay;
      firstDay = newDay;
    } else {
      newDay.nextDay = cursor.nextDay;
      cursor.nextDay = newDay;
    }

    this.size++;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    Day<T, E> cursor = firstDay;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.nextDay;
    }

    Day<T, E> deletedDay = null;
    if (index == 0) {
      deletedDay = firstDay;
      firstDay = deletedDay.nextDay;
    } else {
      deletedDay = cursor.nextDay;
      cursor.nextDay = deletedDay.nextDay;
    }

    deletedDay.nextDay = null;
    size--;

    return deletedDay.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      return null;
    }

    Day<T, E> cursor = firstDay;
    for (int i = 0; i < index; i++) {
      cursor = cursor.nextDay;
    }

    E oldValue = cursor.value;
    cursor.value = value;

    return oldValue;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];

    Day<T, E> cursor = firstDay;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.nextDay;
    }

    return arr;
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {

    if (arr.length < size) {
      arr = (E[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }

    Day<T, E> cursor = firstDay;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.nextDay;
    }

    return arr;
  }

  public int size() {
    return this.size;
  }
}
