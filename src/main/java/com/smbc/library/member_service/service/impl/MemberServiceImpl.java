package com.smbc.library.member_service.service.impl;

import org.apache.logging.log4j.util.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.smbc.library.member_service.dto.FindMemberDto;
import com.smbc.library.member_service.dto.MemberRegisterDto;
import com.smbc.library.member_service.dto.ResponseDto;
import com.smbc.library.member_service.model.Members;
import com.smbc.library.member_service.repository.MemberRepository;
import com.smbc.library.member_service.service.iservice.MemberService;
import com.smbc.library.member_service.utils.ResponseUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public ResponseDto<?> register(MemberRegisterDto registerData) {
        log.info("Inside register new member method...");
        try {
            Members newMember = Members.builder().userId(registerData.getUserId()).fullname(registerData.getFullname())
                    .build();
            Members saved = memberRepository.save(newMember);
            if (saved == null) {
                throw new InternalException("Failed to register new member");
            }

            return ResponseUtil.success(HttpStatus.OK.value(), "Successfully register new member", saved);

        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseUtil.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        }
    }

    @Override
    public ResponseDto<?> findMember(Long userId) {
        Members member = memberRepository.findOneByUserId(userId);

        if (member == null) {
            return ResponseUtil.failed(HttpStatus.NOT_FOUND.value(), "Member data not found");
        }

        FindMemberDto memberDto = FindMemberDto.builder().userId(member.getUserId()).memberId(member.getId())
                .fullname(member.getFullname()).build();
        return ResponseUtil.success(HttpStatus.OK.value(), "Successfully find member by id", memberDto);
    }
}
