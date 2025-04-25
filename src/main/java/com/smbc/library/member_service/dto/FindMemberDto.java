package com.smbc.library.member_service.dto;

import java.io.Serial;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FindMemberDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2314999123L;

    private Long memberId;
    private Long userId;
    private String fullname;

}
