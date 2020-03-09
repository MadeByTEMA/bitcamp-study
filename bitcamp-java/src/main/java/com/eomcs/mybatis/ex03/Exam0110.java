// Mybatis - 자바 객체의 프로퍼티 이름과 컬럼명을 일치시키기 II
package com.eomcs.mybatis.ex03;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Exam0110 {

  public static void main(String[] args) throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(//
        "com/eomcs/mybatis/ex03/mybatis-config.xml");
    SqlSessionFactory factory = //
        new SqlSessionFactoryBuilder().build(inputStream);

    SqlSession sqlSession = factory.openSession();

    Scanner keyScan = new Scanner(System.in);
    System.out.println("게시글 번호? ");
    String str = keyScan.nextLine();

    List<Board> list = null;

    try {
      list = sqlSession.selectList("BoardMapper.select1", Integer.parseInt(str));
    } catch (Exception e) {
      list = sqlSession.selectList("BoardMapper.select2");
    }

    for (Board board : list) {
      System.out.printf("%d, %s, %s, %s, %d\n", //
          board.getNo(), //
          board.getTitle(), //
          board.getRegisteredDate(), //
          board.getViewCount());
    }

    sqlSession.close();
  }

}


