// listBoard() 메서드 변경
// => toArray()의 리턴 값을 사용하는 대신 iterator()의 리턴 값을 사용하여 목록 출력.
package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

public class HelloCommand implements Command {

  Prompt prompt;

  public HelloCommand(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    String name = prompt.inputString("이름? ");

    System.out.printf("%s님 반갑습니다.", name);
  }
}


