package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.models.School;
import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.SchoolService;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/AddSchool")
public class SchoolControlleur {

    private final SchoolService schoolService;

    @GetMapping
    public String AddScholl(Model model){

        model.addAttribute("schools", new School());
        return "School/addschool";
    }

    @PostMapping
    public String saveSchool(SchoolDTO schoolDTO){

        log.debug("Request to save teacher : {}",schoolDTO );
        schoolService.initSchool(schoolDTO);
        return "redirect:/index";
    }
}
