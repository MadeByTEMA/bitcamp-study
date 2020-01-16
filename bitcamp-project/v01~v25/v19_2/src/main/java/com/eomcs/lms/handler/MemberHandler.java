package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.*;
import com.eomcs.util.ArrayList;

public class MemberHandler {

  public Scanner input;
  ArrayList<Member> memberList;

  public MemberHandler(Scanner input) {
    this.input = input;
    memberList = new ArrayList<>();
  }

  public void addMember() {
    Member member = new Member();

    System.out.print("번호? ");
    member.setNo(input.nextInt());
    input.nextLine(); // 줄바꿈 기호 제거용

    System.out.print("이름? ");
    member.setName(input.nextLine());

    System.out.print("이메일? ");
    member.setEmail(input.nextLine());

    System.out.print("암호? ");
    member.setPassword(input.nextLine());

    System.out.print("사진? ");
    member.setPhoto(input.nextLine());

    System.out.print("전화? ");
    member.setTel(input.nextLine());

    member.setRegisteredDate(new Date(System.currentTimeMillis()));

    memberList.add(member);
    System.out.println("저장하였습니다.");
  }

  public void listMember() {
    // Member 객체의 목록을 저장할 배열을 넘기는데 크기가 0인 배열을 넘긴다.
    // toArray()는 내부에서 새 배열을 만들고, 값을 복사한 후 리턴한다.
    Member[] arr = this.memberList.toArray(new Member[] {});
    for (Member m : arr) {
      System.out.printf("%d, %s, %s, %s, %s\n", 
          m.getNo(), m.getName(), m.getEmail(), m.getTel(), m.getRegisteredDate());
    }
  }

  public void detailMember() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfMember(no);

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
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfMember(no);

    if (index == -1) {
      System.out.println("게시문 인덱스가 유효하지 않습니다.");
      return;
    }
    
    Member oldMember = this.memberList.get(index);

    Member newMember = new Member();

    newMember.setNo(oldMember.getNo());

    System.out.printf("이름(%s)? \n", oldMember.getName());
    newMember.setName(input.nextLine());
    if (newMember.getName().length() == 0)
      newMember.setName(oldMember.getName());

    System.out.printf("이메일(%s)? \n", oldMember.getEmail());
    newMember.setEmail(input.nextLine());
    if (newMember.getEmail().length() == 0)
      newMember.setEmail(oldMember.getEmail());

    System.out.printf("암호(%s)? \n", oldMember.getPassword());
    newMember.setPassword(input.nextLine());
    if (newMember.getPassword().length() == 0)
      newMember.setPassword(oldMember.getPassword());

    System.out.printf("사진(%s)? \n", oldMember.getPhoto());
    newMember.setPhoto(input.nextLine());
    if (newMember.getPhoto().length() == 0)
      newMember.setPhoto(oldMember.getPhoto());

    System.out.printf("전화(%s)? \n", oldMember.getTel());
    newMember.setTel(input.nextLine());
    if (newMember.getTel().length() == 0)
      newMember.setTel(oldMember.getTel());

    newMember.setRegisteredDate(new Date(System.currentTimeMillis()));

    this.memberList.set(index, newMember);

    System.out.println("회원을 변경했습니다.");
  }

  public void deleteMember() {
    System.out.print("번호? ");
    int no = input.nextInt();
    input.nextLine();

    int index = indexOfMember(no);

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
