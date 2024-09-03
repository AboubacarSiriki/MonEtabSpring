package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.AppSetting;
import ci.digitalacademy.monetab.services.AppSettingService;
import ci.digitalacademy.monetab.services.SchoolService;
import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class AppSettingcontroller {

    private final AppSettingService appSettingService;
    private final SchoolService schoolService;

    @GetMapping
    public String appSetting(Model model){
        List<SchoolDTO> schoolDTOS = schoolService.findAll();
        List<AppSettingDTO> appSettingDTOS = appSettingService.findAll();
        if( !schoolDTOS.isEmpty() && !appSettingDTOS.isEmpty()) {
            model.addAttribute("schools",schoolDTOS);
            return "Auth/index";
        }else if(appSettingDTOS.isEmpty()){
            model.addAttribute("appsetting", new AppSetting());
            return "AppSetting/welcome";
        }
        else {
            model.addAttribute("school", new SchoolDTO());
            return "AppSetting/welcome";
        }
    }

    @PostMapping
    public String saveAppSetting(AppSettingDTO appSettingDTO, Model model){
        log.debug("Request to save teacher : {}",appSettingDTO );
        appSettingService.initApp(appSettingDTO);

        return "redirect:/AddSchool";
    }
}
