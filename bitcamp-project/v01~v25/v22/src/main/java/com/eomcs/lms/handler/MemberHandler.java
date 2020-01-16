package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.LinkedList;
import com.eomcs.util.Prompt;

public class MemberHandler {

  public Prompt prompt;
  LinkedList<Member> memberList;

  public MemberHandler(Prompt prompt) {
    this.prompt = prompt;
    memberList = new LinkedList<>();
  }

  public void addMember() {
    Member member = new Member();

    member.setNo(prompt.inputInt("번호? "));
    member.setName(prompt.inputString("이름? "));
    member.setEmail(prompt.inputString("이메일? "));
    member.setPassword(prompt.inputString("암호? "));
    member.setPhoto(prompt.inputString("사진? "));
    member.setTel(prompt.inputString("전화? "));
    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);
    System.out.println("저장하였습니다.");
  }

  public void listMember() {
    Member[] arr = this.memberList.toArray(new Member[] {});
    for (Member m : arr) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
    }
  }

  public void detailMember() {
    int index = indexOfMember(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시문 인덱스가 유효하지 않습니다.");
      return;
    }
    
    Member member = this.memberList.get(index);

    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("암호: %s\n", member.getPassword());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("가입일: %s\n", member.getRegisteredDate());
  }

  public void updateMember() {
    int index = indexOfMember(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시문 인덱스가 유효하지 않습니다.");
      return;
    }
    
    Member oldMember = this.memberList.get(index);

    Member newMember = new Member();

    newMember.setNo(oldMember.getNo());
    
    newMember.setName(prompt.inputString(
        String.format("이름(%s)? \n", oldMember.getName()), 
        oldMember.getName()));

    newMember.setEmail(prompt.inputString(
        String.format("이메일(%s)? \n", oldMember.getEmail()), 
        oldMember.getEmail()));
    
    newMember.setPassword(prompt.inputString(
        String.format("암호(%s)? \n", oldMember.getPassword()), 
        oldMember.getPassword()));
    
    newMember.setPhoto(prompt.inputString(
        String.format("사진(%s)? \n", oldMember.getPhoto()), 
        oldMember.getPhoto()));
    
    newMember.setTel(prompt.inputString(
        String.format("전화(%s)? \n", oldMember.getTel()), 
        oldMember.getTel()));
    
    newMember.setRegisteredDate(new Date(System.currentTimeMillis()));

    if (!oldMember.equals(newMember) ) {
      System.out.println("회원 변경을 취소했습니다.");
      return;
    }
    this.memberList.set(index, newMember);
    System.out.println("회원을 변경했습니다.");
  }

  public void deleteMember() {
    int index = indexOfMember(prompt.inputInt("번호? "));

    if (index == -1) {
      System.out.println("게시문 인덱스가 유효하지 않습니다.");
      return;
    }
    
    this.memberList.remove(index);

    System.out.println("회원을 삭제하였습니다.");
  }
  
  private int indexOfMember(int no) {
    for (int i = 0; i < this.memberList.size(); i++) {
      Member temp = this.memberList.get(i);
      if (temp.getNo() == no) {
        return i;
      }
    }
    return -1;
  }
}
