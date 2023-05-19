package org.jinha.board.controllers.admins;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.jinha.board.commons.configs.ConfigInfoService;
import org.jinha.board.commons.configs.ConfigSaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log
@RequestMapping("/admin/config")
@RequiredArgsConstructor
public class ConfigController {
    private final ConfigSaveService saveService;
    private final ConfigInfoService infoService;
    private String code = "siteConfig";
    @GetMapping
    public String config(Model model){
       // model.addAttribute("message","수정완료~!");
        commonProcess(model);
        ConfigForm configForm = infoService.get(code, ConfigForm.class);
//        if(configForm != null) {
//            log.info(configForm.toString());
//        }
        model.addAttribute("configForm", configForm == null?new ConfigForm() : configForm);
        return "admin/config";
    }
    @PostMapping
    public String configPs(ConfigForm configForm, Model model){
        commonProcess(model);
        saveService.save(code, configForm);
        model.addAttribute("message","설정이 저장되었습니다.");
        return "admin/config";
    }
    private void commonProcess(Model model){
        String title="사이트 설정";
        String menuCode= "config";
        model.addAttribute("pageTitle", title);
        model.addAttribute("title", title);
        model.addAttribute("menuCode", menuCode);
    }
}
