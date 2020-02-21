// LMS 클라이언트
package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import com.eomcs.lms.handler.Command;
import com.eomcs.util.Prompt;

public class ClientApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  Deque<String> commandStack;
  Queue<String> commandQueue;


  public ClientApp() throws Exception {
    commandStack = new ArrayDeque<>();
    commandQueue = new LinkedList<>();
  }

  public void service() {

    while (true) {
      String command;
      command = prompt.inputString("\n명령> ");

      if (command.length() == 0)
        continue;

      if (command.equals("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equals("history2")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      } else if (command.equals("quit")) {
        break;
      }

      commandStack.push(command);
      commandQueue.offer(command);

      processCommand(command);
    }
    keyboard.close();

    try {
    } catch (Exception e) {
    }
  }

  private void processCommand(String command) {
    Command commandHandler = commandMap.get(command);
    if (commandHandler == null) {
      System.out.println("실행할 수 없는 명령입니다.");
      return;
    }
    commandHandler.execute();
  }

  private void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if ((count % 5) == 0) {
        String str = prompt.inputString(":");
        if (str.equalsIgnoreCase("q")) {
          break;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("클라이언트 수업 관리 시스템입니다.");

    ClientApp app = new ClientApp();
    app.service();
  }
}
