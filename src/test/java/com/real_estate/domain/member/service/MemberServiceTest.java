package com.real_estate.domain.member.service;

import com.real_estate.domain.member.domain.Member;
import com.real_estate.domain.member.domain.MemberRepository;
import com.real_estate.domain.member.domain.MemberRole;
import com.real_estate.domain.member.dto.MemberSaveDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @DisplayName("[기능테스트] 사용자 등록")
    @Test
    public void save() {
        //given
        memberService.save(MemberSaveDto.builder()
                .name("테스터")
                .email("test@test.com")
                .password("1111")
                .userRole(MemberRole.USER)
                .build());

        List<Member> list = memberRepository.findAll();
        assertThat(list.get(0).getName()).isEqualTo("테스터");
    }

}