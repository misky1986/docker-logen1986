package com.sourcecabin.services;

import com.sourcecabin.entities.Member;

import java.util.List;

public interface MemberService {

    void create(String name, Integer age, String nickname, String role);

    void update(Member memberEntity);

    void remove(long id);

    Member find(long id);

    List<Member> findAllMembers();
}
