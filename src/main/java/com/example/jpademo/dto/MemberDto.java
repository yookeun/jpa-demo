package com.example.jpademo.dto;


import com.example.jpademo.entity.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {
    private Long memberId;
    @NotBlank(message = "userId 필수입력")
    private String userId;
    @NotBlank(message = "userName 필수입력")
    private String userName;

    @Builder.Default
    private List<ItemDto> itemDtos = new ArrayList<>();


    public Member toEntity() {
        return Member.builder()
                .userId(userId)
                .userName(userName)
                .build();
    }

    public static MemberDto of(Member member) {
        return MemberDto.builder()
                .memberId(member.getMemberId())
                .userId(member.getUserId())
                .userName(member.getUserName())
                .itemDtos(member.getItemDtos())
                .build();
    }
}
