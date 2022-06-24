package com.example.jpademo.entity;

import com.example.jpademo.dto.MemberDto;
import com.example.jpademo.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "user_id", length = 50)
    private String userId;

    @Column(name = "user_name", length = 50)
    private String userName;

    public void update(MemberDto memberDto) {
        this.userId = memberDto.getUserId();
        this.userName = memberDto.getUserName();
    }
}
