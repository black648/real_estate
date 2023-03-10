package com.real_estate.domain.member.dto;

import com.real_estate.domain.member.domain.Member;
import com.real_estate.domain.member.domain.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveDto {
    private String email;
    private String password;
    private String name;
    private MemberRole memberRole;

    @Builder(toBuilder = true)
    public MemberSaveDto(String email, String password, String name, MemberRole memberRole) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.memberRole = memberRole;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .memberRole(memberRole)
                .build();
    }
}
