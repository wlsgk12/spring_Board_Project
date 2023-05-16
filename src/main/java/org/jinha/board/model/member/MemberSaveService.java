package org.jinha.board.model.member;

import lombok.RequiredArgsConstructor;
import org.jinha.board.controllers.members.JoinForm;
import org.jinha.board.entities.Member;
import org.jinha.board.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 회원 정보 추가, 수정
 * 수정시 비밀번호는 null 이 아닐 때만 수정
 */
@Service
@RequiredArgsConstructor
public class MemberSaveService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    public void save(JoinForm joinForm){
        Member member = new ModelMapper().map(joinForm, Member.class);
        member.setUserPw(passwordEncoder.encode(joinForm.getUserPw()));

        memberRepository.saveAndFlush(member);
    }

}
