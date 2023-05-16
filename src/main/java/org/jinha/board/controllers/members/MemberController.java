package org.jinha.board.controllers.members;

import lombok.RequiredArgsConstructor;
import org.jinha.board.model.member.MemberSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberSaveService saveService;
    private final JoinValidator joinValidator;
    @GetMapping("/join")
    public String join(@ModelAttribute JoinForm joinForm, Model model){

        return "member/join";
    }
    @PostMapping("/join")
    public String joinPs(JoinForm joinForm, Errors errors){

        joinValidator.validate(joinForm, errors);

        if(errors.hasErrors()){
            return "member/join";
        }
        saveService.save(joinForm);

        return "redirect:/member/login";
    }
}
