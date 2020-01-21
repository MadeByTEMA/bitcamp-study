// listBoard() 메서드 변경
// => toArray()의 리턴 값을 사용하는 대신 iterator()의 리턴 값을 사용하여 목록 출력.
package com.eomcs.lms.handler;

import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {

  List<Board> boardList;

  public BoardListCommand(List<Board> list) {
    this.boardList = list;
  }

  @Override
  public void execute() {
    // BoardList 에게 값을 꺼내는 일을 해줄 Iterator 객체을 달라고 한다.
    Iterator<Board> iterator = boardList.iterator();

    // Iterator 객체에게 목록에서 꺼낼 값이 있는지 물어본다.
    while (iterator.hasNext()) {

      // 값이 있다고 한다면, 그 값을 꺼내 달라고 요청한다.
      Board b = iterator.next();

      System.out.printf("%d, %s, %s, %d\n", b.getNo(), b.getTitle(), b.getDate(), b.getViewCount());
    }
  }
}


