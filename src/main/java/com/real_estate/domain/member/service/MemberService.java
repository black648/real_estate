package com.real_estate.domain.member.service;

import com.real_estate.domain.member.domain.MemberRepository;
import com.real_estate.domain.member.dto.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    Long save(MemberSaveDto saveDto) {
        return memberRepository.save(saveDto.toEntity()).getId();
    }
}

