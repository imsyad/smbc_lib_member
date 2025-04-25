package com.smbc.library.member_service.service.iservice;

import com.smbc.library.member_service.dto.MemberRegisterDto;
import com.smbc.library.member_service.dto.ResponseDto;

public interface MemberService {
    ResponseDto<?> register(MemberRegisterDto registerData);

    ResponseDto<?> findMember(Long userId);
}
