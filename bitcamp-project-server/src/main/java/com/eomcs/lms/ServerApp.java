// LMS 서버
package com.eomcs.lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.servlet.BoardAddServlet;
import com.eomcs.servlet.BoardDeleteServlet;
import com.eomcs.servlet.BoardDetailServlet;
import com.eomcs.servlet.BoardListServlet;
import com.eomcs.servlet.BoardUpdateServlet;
import com.eomcs.servlet.LessonAddServlet;
import com.eomcs.servlet.LessonDeleteServlet;
import com.eomcs.servlet.LessonDetailServlet;
import com.eomcs.servlet.LessonListServlet;
import com.eomcs.servlet.LessonUpdateServlet;
import com.eomcs.servlet.MemberAddServlet;
import com.eomcs.servlet.MemberDeleteServlet;
import com.eomcs.servlet.MemberDetailServlet;
import com.eomcs.servlet.MemberListServlet;
import com.eomcs.servlet.MemberUpdateServlet;
import com.eomcs.servlet.Servlet;

public class ServerApp {

  // 옵저버 관련 코드
  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();
  Map<String, Servlet> servletMap = new HashMap<>();

  List<Board> boards;
  List<Member> members;
  List<Lesson> lessons;

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }
  // 옵저버 관련코드 끝!

  @SuppressWarnings("unchecked")
  public void service() {

    notifyApplicationInitialized();

    // DataLoaderListener가 준비한 데이터를 꺼내 인스턴스 필드에 저장한다.
    boards = (List<Board>) context.get("boardList");
    members = (List<Member>) context.get("memberList");
    lessons = (List<Lesson>) context.get("lessonList");

    servletMap.put("/board/list", new BoardListServlet(boards));
    servletMap.put("/board/add", new BoardAddServlet(boards));
    servletMap.put("/board/detail", new BoardDetailServlet(boards));
    servletMap.put("/board/update", new BoardUpdateServlet(boards));
    servletMap.put("/board/delete", new BoardDeleteServlet(boards));

    servletMap.put("/lesson/list", new LessonListServlet(lessons));
    servletMap.put("/lesson/add", new LessonAddServlet(lessons));
    servletMap.put("/lesson/detail", new LessonDetailServlet(lessons));
    servletMap.put("/lesson/update", new LessonUpdateServlet(lessons));
    servletMap.put("/lesson/delete", new LessonDeleteServlet(lessons));

    servletMap.put("/member/list", new MemberListServlet(members));
    servletMap.put("/member/add", new MemberAddServlet(members));
    servletMap.put("/member/detail", new MemberDetailServlet(members));
    servletMap.put("/member/update", new MemberUpdateServlet(members));
    servletMap.put("/member/delete", new MemberDeleteServlet(members));



    try (
        // 서버쪽 연결 준비
        // => 클라이언트의 연결을 9999번 포트에서 기다린다.
        ServerSocket serverSocket = new ServerSocket(9999)) {

      System.out.println("클라이언트 연결 대기중...");

      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("클라이언트와 연결되었음!");

        if (processRequest(socket) == 9) {
          break;
        }

        System.out.println("--------------------------------------");
      }

    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생!");
    }

    notifyApplicationDestroyed();

  } // service()


  int processRequest(Socket clientSocket) {

    try (Socket socket = clientSocket;
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

      while (true) {
        String request = in.readUTF();
        System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

        switch (request) {
          case "quit":
            quit(out);
            return 0; // 클라이언트와 연결을 끊는다.
          case "/server/stop":
            quit(out);
            return 9; // 서버를 종료한다.
        }
        Servlet servlet = servletMap.get(request);

        if (servlet != null) {
          try {
            servlet.service(in, out);

          } catch (Exception e) {
            out.writeUTF("FAIL");
            out.writeUTF(e.getMessage());

            System.out.println("클라이언트 요청 처리 중 오류 발생:");
            e.printStackTrace();
          }

        } else {
          notFound(out);
        }

        out.flush();
        System.out.println("클라이언트에게 응답하였음!");
        System.out.println("--------------------------");
      }
    } catch (Exception e) {
      System.out.println("예외 발생:");
      e.printStackTrace();
      return -1;
    }
  }

  private void notFound(ObjectOutputStream out) throws IOException {
    out.writeUTF("FAIL");
    out.writeUTF("요청한 명령을 처리할 수 없습니다.");
  }

  private void quit(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.flush();
  }

  public static void main(String[] args) {
    System.out.println("서버 수업 관리 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
