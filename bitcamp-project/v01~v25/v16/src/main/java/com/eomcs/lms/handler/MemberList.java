package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Member;

public class MemberList {

  static final int MEMBER_SIZE = 100;
  Member[] members;
  int memberCount;

  public MemberList() {
    this.members = new Member[MEMBER_SIZE];
  }

  public void add(Member member) {
    this.members[this.memberCount] = member;
  }

  public Member[] toArray() {
    Member[] arr = new Member[this.memberCount];
    for (int i = 0; i < this.memberCount; i++) {
      arr[i] = this.members[i];
    }
    return arr;
  }
  public Member get(int no) {
    for(int i = 0; i < this.memberCount; i++) {
      if(this.members[i].getNo() == no)
        return this.members[i];
    }

    return null;
  }
}