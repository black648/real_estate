package com.real_estate.domain.login.dto;

import com.real_estate.domain.member.domain.Member;
import com.real_estate.domain.member.domain.MemberRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginDto {
    private String email;
    private String password;
    private String name;
    private MemberRole memberRole;
    private String tokenKey;

    @Builder
    public LoginDto(String email, String password, String name, MemberRole memberRole, String tokenKey) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.memberRole = memberRole;
        this.tokenKey = tokenKey;
    }

    public static LoginDto of(Member member, String tokenKey) {
        return LoginDto.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .name(member.getName())
                .memberRole(member.getMemberRole())
                .tokenKey(tokenKey)
                .build();
    }
}
