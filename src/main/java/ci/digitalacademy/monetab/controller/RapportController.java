package ci.digitalacademy.monetab.controller;

import ci.digitalacademy.monetab.services.SchoolService;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Rapport")
@RequiredArgsConstructor
public class RapportController {

    private final SchoolService schoolService;

    @GetMapping
    public String showRapport(Model model){

        List<SchoolDTO> schoolDTOS = schoolService.findAll();
        model.addAttribute("schools",schoolDTOS);
        return "/Rapport/rapport";
    }
}
