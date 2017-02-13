package com.sourcecabin.services;

import com.sourcecabin.entities.Member;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MemberServiceImpl implements MemberService {

    @PersistenceContext(unitName = "mongo-ogm")
    private EntityManager em;

    @Override
    public void create(String name, Integer age, String nickname, String role) {
        Member memberEntity = new Member();
        memberEntity.setName(name);
        memberEntity.setAge(age);
        memberEntity.setNickName(nickname);
        memberEntity.setRole(role);
        em.persist(memberEntity);
    }

    @Override
    public Member find(long id) {
        return em.find(Member.class, id);
    }

    @Override
    public List<Member> findAllMembers() {
        Query query = em.createQuery("FROM Member m");
        List<Member> list = query.getResultList();
        return list;
    }

    @Override
    public void update(Member memberEntity) {
        em.merge(memberEntity);
    }

    @Override
    public void remove(long id) {
        Member member = find(id);
        em.remove(member);
    }

}
