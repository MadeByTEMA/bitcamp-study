package com.eomcs.util;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;
public class ArrayList<E> {

  static final int DEFAULT_CAPACITY = 3;
  Object[] list;
  int size;

  public ArrayList() {
    this.list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int capacity) {
    if (capacity < DEFAULT_CAPACITY || capacity > 10000)
      this.list = new Object[DEFAULT_CAPACITY];
    else
      this.list = new Object[capacity];
  }

  @SuppressWarnings({"unchecked"})
  public E[] toArray(E[] arr) {
    if (arr.length < this.size) {
      return (E[]) Arrays.copyOf(this.list, this.size, arr.getClass());
      }
    System.arraycopy(this.list, 0, arr, 0, this.size);
    /*
    // 위의 arraycopy는 다음 코드와 같다.
    for (int i = 0; i < this.size; i++) {
      arr[i] = (E)this.list[i];
    }
    */
   return arr;
  }
  
  public void add(E obj) {
    if(this.size == this.list.length) {
      int oldCapacity = this.list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = obj;
  }

  @SuppressWarnings("unchecked")
  public E get(int idx) { 
    if (idx >= 0 && idx < this.size) {
      return (E)this.list[idx];
    } else {
      return null;
    }
  }
  
  public E set(int index, E obj) {
    if (index < 0 || index >= this.size)
      return;
    
    E old = (E) this.list[index];
    this.list[index] = obj;
    
    return old;
  }
  
  public E remove(int index) {
    if (index < 0 || index >= this.size)
      return null;
    
    // 삭제할 항목을 따로 보관해둔다.
    E old = (E) this.list[index];
    
    for(int i = index + 1; i < this.size; i++) {
      this.list[i - 1] = this.list[i]
    }
    
    this size --;
    
    this.list[this.size] = null; 
    
    // 삭제한 항목을 리턴한다.
    return old;
  }
  
  public int size() {
    return this.size;
  }
}
