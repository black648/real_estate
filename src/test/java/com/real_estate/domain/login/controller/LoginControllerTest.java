package com.real_estate.domain.login.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.real_estate.domain.login.dto.LoginDto;
import com.real_estate.domain.login.service.LoginService;
import com.real_estate.domain.member.domain.Member;
import com.real_estate.domain.member.domain.MemberRepository;
import com.real_estate.domain.member.domain.MemberRole;
import com.real_estate.domain.member.dto.MemberSaveDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class LoginControllerTest {
    @Autowired
    MockMvc mvc;

    @Autowired
    LoginService loginService;

    @Autowired
    MemberRepository memberRepository;

    @DisplayName("[API테스트] 회원가입")
    @Test
    void join() throws Exception {
        mvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(
                                MemberSaveDto.builder()
                                        .email("test@test.com")
                                        .password("1111")
                                        .name("테스터")
                                        .memberRole(MemberRole.USER)
                                        .build())))
                .andExpect(status().isOk());

        List<Member> list = memberRepository.findAll();
        assertThat(list.get(0).getName()).isEqualTo("테스터");
    }
    
    @DisplayName("[API테스트] 로그인")
    @Test
    void login() throws Exception {
        LoginDto loginDto = loginService.doJoin(
                MemberSaveDto.builder()
                        .email("test@test.com")
                        .password("1111")
                        .name("테스터")
                        .memberRole(MemberRole.USER)
                        .build());
        mvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(
                                LoginDto.builder()
                                    .email(loginDto.getEmail())
                                    .password("1111")
                                    .build())))
                .andExpect(status().isOk());
    }
}