package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {

  final int DEFAULT_CAPACITY = 10;
  Object[] elementData;
  int size;

  public ArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if(initialCapacity < DEFAULT_CAPACITY) {
      this.elementData = new Object[DEFAULT_CAPACITY];
    } else {
      this.elementData = new Object[initialCapacity];
    }
  }
  
  public void add (E e) {
    if (this.size == this.elementData.length) {
      int oldSize = this.elementData.length;
      int newSize = oldSize + oldSize >> 2;
    
    this.elementData = Arrays.copyOf(this.elementData, newSize);
    /*
      Object[] newArr = new Object[newSize];
      for (int i = 0; i < this.size; i++) {
        newArr[i] = this.elementData[i];
      }
      this elementData = newArr;
      */
    }
    this.elementData[this.size++] = e;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.elementData[index];
  }
  
  @SuppressWarnings("unchecked")
  public E set(int index, E e) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    E oldValue = (E) this.elementData[index];
    this.elementData[index] = e;
    return oldValue;
  }
  
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    
    E oldValue = (E) this.elementData[index];
    System.arraycopy(this.elementData, index + 1, this.elementData, index, this.size);
    /*
    for (int i = index + 1; i < this.size; i++) {
      this.elementData[i - 1] = this.elementData[i];
    }
    */
    this.size--;
    return oldValue;
  }
  
  public int size() {
    return this.size;
  }
  
  public Object[] toArray() {
    return Arrays.copyOf(this.elementData, this.size);
    /*
    Object[] arr = new Object[this.size];
    for (int i = 0; i < this.size; i++) {
      arr[i] = this.elementData[i];
    }
    return arr;
    */
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      // 파라미터로 받은 배열이 작을 떄는 새 배열을 만들어 리턴
    return (E[]) Arrays.copyOf(this.elementData, this.size, arr.getClass());
    }
    System.arraycopy(this.elementData, 0, arr, 0, this.size);
    return arr;
    // 넉넉할 때는 파라미터로 받은 배열을 그대로 리턴.
  }
  
  public void add(int index, E value) {
    if (index < 0 || index >= this.size)
      return;

    if (this.size == this.elementData.length) {
      grow();
    }

    for (int i = size - 1; i >= index; i--)
      this.elementData[i + 1] = this.elementData[i];

    this.elementData[index] = value;
    this.size++;
  }
  
  private Object[] grow() {
    return this.elementData = Arrays.copyOf(this.elementData, 
        newCapacity());
  }
  
  private int newCapacity() {
    int oldSize = this.elementData.length;
    return oldSize + (oldSize >> 1);
  }
  
}