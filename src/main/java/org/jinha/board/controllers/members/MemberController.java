package org.jinha.board.controllers.members;

import lombok.RequiredArgsConstructor;
import org.jinha.board.model.member.MemberSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private MemberSaveService saveService;
    @GetMapping("/join")
    public String join(){

        return "member/join";
    }
    @PostMapping("/join")
    public String joinPs(JoinForm joinForm, Errors errors){
        if(errors.hasErrors()){
            return "member/join";
        }
        saveService.save(joinForm);

        return "redirect:/member/login";
    }
}
