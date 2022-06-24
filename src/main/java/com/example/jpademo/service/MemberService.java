package com.example.jpademo.service;

import com.example.jpademo.dto.MemberDto;
import com.example.jpademo.entity.Member;
import com.example.jpademo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberDto save(MemberDto memberDto) {
        Member saveMember = memberRepository.save(memberDto.toEntity());
        return MemberDto.of(saveMember);
    }

    @Transactional
    public MemberDto update(MemberDto memberDto) {
        Member findMember = memberRepository
                .findById(memberDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));
        findMember.update(memberDto);
        return MemberDto.of(findMember);
    }

    public MemberDto getOne(Long id) {
        Member findMember = memberRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));
        return MemberDto.of(findMember);
    }

    @Transactional
    public void delete(MemberDto memberDto) {
        Member findMember = memberRepository
                .findById(memberDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));
        memberRepository.delete(findMember);
    }
}
