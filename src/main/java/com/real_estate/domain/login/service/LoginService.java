package com.real_estate.domain.login.service;

import com.real_estate.domain.login.dto.LoginDto;
import com.real_estate.domain.member.domain.Member;
import com.real_estate.domain.member.domain.MemberRepository;
import com.real_estate.domain.member.dto.MemberSaveDto;
import com.real_estate.domain.member.service.MemberService;
import com.real_estate.global.config.security.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public LoginDto doJoin(MemberSaveDto dto) {
//        dto = dto.toBuilder().password(passwordEncoder.encode(dto.getPassword())).build();
        Member member = memberRepository.save(dto.toEntity());

        return LoginDto.of(member, tokenProvider.createToken(member));
    }

    public LoginDto doLogin(String email, String password) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email).orElseThrow(()
                -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(password, member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return LoginDto.of(member, tokenProvider.createToken(member));
    }

    public boolean checkToken(String tokenKey) {
        return true;
    }

}
