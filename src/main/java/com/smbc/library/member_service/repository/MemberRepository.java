package com.smbc.library.member_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smbc.library.member_service.model.Members;

@Repository
public interface MemberRepository extends JpaRepository<Members, Long> {

    Members findOneByUserId(Long userId);
}
