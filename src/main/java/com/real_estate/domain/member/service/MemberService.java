package com.real_estate.domain.member.service;

import com.real_estate.domain.member.domain.Member;
import com.real_estate.domain.member.domain.MemberRepository;
import com.real_estate.domain.member.dto.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    public Member save(MemberSaveDto saveDto) {
        saveDto = saveDto.toBuilder().password(passwordEncoder.encode(saveDto.getPassword())).build();
        return memberRepository.save(saveDto.toEntity());
    }
}

