package com.example.jpademo.control;

import com.example.jpademo.dto.MemberDto;
import com.example.jpademo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public MemberDto save(@RequestBody @Valid MemberDto memberDto) {
        return memberService.save(memberDto);
    }

    @PutMapping("/{id}")
    public MemberDto update(@PathVariable(name = "id") Long id, @RequestBody @Valid MemberDto memberDto) {
        memberDto.setMemberId(id);
        return memberService.update(memberDto);
    }

    @GetMapping("/{id}")
    public MemberDto getOne(@PathVariable(name = "id") Long id) {
        return memberService.getOne(id);
    }

    @DeleteMapping
    public void delete(@RequestParam(name = "id") Long id) {
        MemberDto memberDto = MemberDto.builder().memberId(id).build();
        memberService.delete(memberDto);
    }
}
