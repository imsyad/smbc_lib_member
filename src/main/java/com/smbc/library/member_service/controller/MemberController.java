package com.smbc.library.member_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smbc.library.member_service.dto.MemberRegisterDto;
import com.smbc.library.member_service.dto.ResponseDto;
import com.smbc.library.member_service.service.iservice.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseDto<?> registerMember(@RequestBody @Valid MemberRegisterDto registerData) {
        return memberService.register(registerData);
    }

    @GetMapping()
    public ResponseDto<?> findMemberByUserId(@RequestParam Long userId) {
        return memberService.findMember(userId);
    }

}
