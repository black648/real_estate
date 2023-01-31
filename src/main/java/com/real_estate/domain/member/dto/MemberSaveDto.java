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
    private MemberRole userRole;

    @Builder
    public MemberSaveDto(String email, String password, String name, MemberRole userRole) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.userRole = userRole;
    }

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .userRole(userRole)
                .build();
    }
}
