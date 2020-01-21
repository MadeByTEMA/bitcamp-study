package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberAddCommand implements Command {

  List<Member> memberList;

  Prompt prompt;

  public MemberAddCommand(Prompt prompt, List<Member> list) {
    this.prompt = prompt;
    this.memberList = list;
  }

  public void listMember() {

    // 목록에서 값을 꺼내는 일을 해 줄 Iterator 객체를 준비한다.
    Iterator<Member> iterator = memberList.iterator();

    // Iterator 객체를 통해 값을 꺼낸다.
    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("%d, %s, %s, %s, %s\n", m.getNo(), m.getName(), m.getEmail(), m.getTel(),
          m.getRegisteredDate());
    }
  }

  @Override
  public void execute() {
    Member member = new Member();

    member.setNo(prompt.inputInt("번호? "));
    member.setName(prompt.inputString("이름? "));
    member.setEmail(prompt.inputString("이메일? "));
    member.setPassword(prompt.inputString("암호? "));
    member.setPhoto(prompt.inputString("사진? "));
    member.setTel(prompt.inputString("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    this.memberList.add(member);

    System.out.println("저장하였습니다.");
  }
}
