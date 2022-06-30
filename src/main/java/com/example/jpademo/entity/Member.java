package com.example.jpademo.entity;

import com.example.jpademo.dto.ItemDto;
import com.example.jpademo.dto.MemberDto;
import com.example.jpademo.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @OneToMany
    @JoinTable(name = "my_item",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @Builder.Default
    private List<Item> items = new ArrayList<>();

    public void addItems(Item item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    public List<ItemDto> getItemDtos() {
        return items.stream().map(item -> ItemDto.of(item)).collect(Collectors.toList());
    }


    public void update(MemberDto memberDto) {
        this.userId = memberDto.getUserId();
        this.userName = memberDto.getUserName();
    }
}
