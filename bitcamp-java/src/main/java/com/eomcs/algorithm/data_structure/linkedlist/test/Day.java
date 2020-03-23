package com.eomcs.algorithm.data_structure.linkedlist.test;

import java.lang.reflect.Array;

public class Day<T, E> {
  E value;
  Block<T> firstBlock;
  Block<T> lastBlock;
  Day<T, E> nextDay;
  int size;

  public void add(T value) {
    Block<T> newBlock = new Block<>();
    newBlock.value = value;

    if (firstBlock == null) {
      firstBlock = lastBlock = newBlock;
    } else {
      lastBlock.next = newBlock;
      lastBlock = newBlock;
    }

    this.size++;
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    Block<T> cursor = firstBlock;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  public void add(int index, T value) {
    if (index < 0 || index >= size) {
      return;
    }

    Block<T> newBlock = new Block<>();
    newBlock.value = value;

    Block<T> cursor = firstBlock;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }

    if (index == 0) {
      newBlock.next = firstBlock;
      firstBlock = newBlock;
    } else {
      newBlock.next = cursor.next;
      cursor.next = newBlock;
    }

    this.size++;
  }

  public T remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    Block<T> cursor = firstBlock;
    for (int i = 0; i < index - 1; i++) {
      cursor = cursor.next;
    }

    Block<T> deletedBlock = null;
    if (index == 0) {
      deletedBlock = firstBlock;
      firstBlock = deletedBlock.next;
    } else {
      deletedBlock = cursor.next;
      cursor.next = deletedBlock.next;
    }

    deletedBlock.next = null;
    size--;

    return deletedBlock.value;
  }

  public T set(int index, T value) {
    if (index < 0 || index >= size) {
      return null;
    }

    Block<T> cursor = firstBlock;
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }

    T oldValue = cursor.value;
    cursor.value = value;

    return oldValue;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];

    Block<T> cursor = firstBlock;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

  @SuppressWarnings("unchecked")
  public T[] toArray(T[] arr) {

    if (arr.length < size) {
      arr = (T[]) Array.newInstance(arr.getClass().getComponentType(), size);
    }

    Block<T> cursor = firstBlock;
    for (int i = 0; i < size; i++) {
      arr[i] = cursor.value;
      cursor = cursor.next;
    }

    return arr;
  }

  public int size() {
    return this.size;
  }
}
