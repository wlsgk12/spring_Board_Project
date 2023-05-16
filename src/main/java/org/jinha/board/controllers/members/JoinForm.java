package org.jinha.board.controllers.members;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class JoinForm {
    @NotBlank
    private String userId;
    @NotBlank
    private String userPw;
    @NotBlank
    private String userPwRe;
    @NotBlank
    private String userNm;
    @NotBlank @Email
    private String email;
    private String mobile;

    private boolean[] agrees;
}
