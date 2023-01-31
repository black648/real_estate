package com.real_estate.domain.member.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberRole {
    USER("ROLE_USER", "일반회원"),
    AGENT("ROLE_AGENT", "중개인"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;

}