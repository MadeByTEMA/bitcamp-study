package com.eomcs.util;

// Queue 객체에서 Iterator의 규칙을 따라 값을 꺼내주는 클래스를 정의
public class QueueIterator<E> implements Iterator<E> {

  Queue<E> queue;

  public QueueIterator(Queue<E> queue) {
    this.queue = queue.clone();
  }

  @Override
  public boolean hasNext() {
    return queue.size() > 0;
  }

  @Override
  public E next() {
    return queue.poll();
  }
}
