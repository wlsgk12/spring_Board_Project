package org.jinha.board.model.member;

import lombok.RequiredArgsConstructor;
import org.jinha.board.entities.Member;
import org.jinha.board.repositories.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberInfoService implements UserDetailsService {
    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByUserId(username);
        if(member == null){
            throw new UsernameNotFoundException(username);
        }

        return MemberInfo.builder()
                .userNo(member.getUserNo())
                .userId(member.getUserId())
                .userPw(member.getUserPw())
                .userNm(member.getUserNm())
                .email(member.getEmail())
                .build();

    }
}