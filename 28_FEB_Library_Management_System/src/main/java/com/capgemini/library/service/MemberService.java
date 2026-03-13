package com.capgemini.library.service;

import com.capgemini.library.entity.Member;
import com.capgemini.library.exception.ResourceNotFoundException;
import com.capgemini.library.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + memberId));
    }

    public Member addMember(Member member) {
        member.setStatus("ACTIVE");
        return memberRepository.save(member);
    }

    public Member updateMember(Long memberId, Member member) {
        Member existing = getMemberById(memberId);
        existing.setName(member.getName());
        existing.setEmail(member.getEmail());
        existing.setPhone(member.getPhone());
        existing.setMemberSince(member.getMemberSince());
        existing.setStatus(member.getStatus());
        return memberRepository.save(existing);
    }

    public void deleteOrDisableMember(Long memberId) {
        Member existing = getMemberById(memberId);
        existing.setStatus("BLOCKED");
        memberRepository.save(existing);
    }
}


