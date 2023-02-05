package com.real_estate.domain.login.service;

import com.real_estate.domain.login.dto.LoginDto;
import com.real_estate.domain.member.domain.Member;
import com.real_estate.domain.member.domain.MemberRepository;
import com.real_estate.domain.member.domain.MemberRole;
import com.real_estate.domain.member.dto.MemberSaveDto;
import com.real_estate.domain.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class LoginServiceTest {
    @Autowired
    LoginService loginService;
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void doLogin() {
        Member member = memberService.save(MemberSaveDto.builder()
                .name("테스터")
                .email("test1@test.com")
                .password("1111")
                .memberRole(MemberRole.USER)
                .build());

        LoginDto loginDto = loginService.doLogin(member.getEmail(), "1111");
    }
}