package com.example.jpademo.control;

import com.example.jpademo.dto.MemberDto;
import com.example.jpademo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberDto save(@RequestBody @Valid MemberDto memberDto) {
        return memberService.save(memberDto);
    }

    @PutMapping("/{memberId}")
    public MemberDto update(@PathVariable Long memberId, @RequestBody @Valid MemberDto memberDto) {
        memberDto.setMemberId(memberId);
        return memberService.update(memberDto);
    }

    @GetMapping("/{memberId}")
    public MemberDto getOne(@PathVariable Long memberId) {
        return memberService.getOne(memberId);
    }

    @DeleteMapping("/{memberId}")
    public void delete(@PathVariable Long memberId) {
        memberService.delete(memberId);
    }

    @PostMapping("/{memberId}/items")
    public MemberDto addItem(@PathVariable Long memberId, @RequestParam Long[] itemIds) {
        return memberService.addItem(memberId, itemIds);
    }

    @GetMapping
    public List<MemberDto> getList() {
        return memberService.getList();
    }
}
