package org.jinha.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Table(indexes = {
        @Index(name = "idx_member_userNm", columnList = "userNm"),
        @Index(name = "idx_member_email", columnList = "email")
})
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    private Long userNo; //회원 번호
    @Column(length = 40, nullable = false, unique = true)
    private String userId; //회원 아이디
    @Column(length = 65, nullable = false)
    private String userPw; //비밀번호
    @Column(length = 40, nullable = false)
    private String userNm; //회원명

    //비밀번호를 잃어버렸을 때 이메일 기반으로 비밀번호 초기화 적용시킬 거
    @Column(length = 100,nullable = false)
    private String email; //이메일
    @Column(length = 11)
    private String mobile; //휴대전화번호
    //약관 JSON 형태로 넣어줄 것임
    @Lob
    private String termsAgree; //약관 동의 내역
}
