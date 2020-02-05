package com.eomcs.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailServlet implements Servlet {

  List<Lesson> lessons;

  public LessonDetailServlet(List<Lesson> lessons) {
    this.lessons = lessons;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    int no = in.readInt();

    Lesson lesson = null;
    for (Lesson b : lessons) {
      if (b.getNo() == no) {
        lesson = b;
        break;
      }
    }

    if (lesson != null) {
      out.writeUTF("OK");
      out.writeObject(lesson);

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 번호의 게시물이 없습니다.");
    }
  }
}



