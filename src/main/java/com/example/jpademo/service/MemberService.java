package com.example.jpademo.service;

import com.example.jpademo.dto.MemberDto;
import com.example.jpademo.entity.Item;
import com.example.jpademo.entity.Member;
import com.example.jpademo.repository.ItemRepository;
import com.example.jpademo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

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

    public MemberDto getOne(Long memberId) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));
        return MemberDto.of(member);
    }

    @Transactional
    public void delete(Long memberId) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));
        memberRepository.delete(member);
    }

    @Transactional
    public MemberDto addItem(Long memberId, Long[] itemIds) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 ID"));

        for (Long itemId : itemIds) {
            Item item = itemRepository.findById(itemId)
                    .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 Item ID"));
            member.addItems(item);
        }
        return MemberDto.of(member);
    }

    public List<MemberDto> getList() {
        return memberRepository.findAll()
                .stream()
                .map(member -> MemberDto.of(member))
                .collect(Collectors.toList());
    }
}
