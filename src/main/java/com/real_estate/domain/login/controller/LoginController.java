package com.real_estate.domain.login.controller;

import com.real_estate.domain.login.service.LoginService;
import com.real_estate.domain.member.dto.MemberSaveDto;
import com.real_estate.global.result.ResultAPI;
import com.real_estate.global.result.ResultSet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/join")
    public ResultAPI join(@RequestBody MemberSaveDto saveDto) {
        return ResultSet.resultData(loginService.doJoin(saveDto));
    }

    @PostMapping("/login")
    public ResultAPI login(@RequestBody Map<String, String> paramMap) {
        return ResultSet.resultData(loginService.doLogin(paramMap.get("email"), paramMap.get("password")));
    }
}
