package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

public class ComputePlus implements Command {

  Prompt prompt;

  public ComputePlus(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    int no1 = prompt.inputInt("수1? ");
    int no2 = prompt.inputInt("수2? ");
    System.out.println("계산결과는 " + (no1 + no2) + " 입니다.");
  }

}
