package com.real_estate.global.code.service;

import com.real_estate.global.code.domain.Code;
import com.real_estate.global.code.domain.Repository.CodeRepository;
import com.real_estate.global.code.dto.CodeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CodeService {
    private final CodeRepository codeRepository;

    public CodeResponseDto get(String cd) {
        Code code = codeRepository.findById(cd).orElseThrow(() ->
                new IllegalArgumentException("조회된 방이 없습니다."));

        return new CodeResponseDto(code);
    }

}
