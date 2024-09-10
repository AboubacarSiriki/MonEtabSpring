package ci.digitalacademy.monetab.web.ressources;

import ci.digitalacademy.monetab.services.StudentService;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/students")
public class StudentRessource {

    private final StudentService studentService;

    @PostMapping
    public StudentDTO saveStudent( @RequestBody StudentDTO studentDTO){
        log.debug("Rest Request to save {}", studentDTO);
        return null;
    }

    public StudentDTO updateStudent(StudentDTO studentDTO){
        return null;
    }


    public StudentDTO getStudent( Long id){
        return null;
    }


    public List<StudentDTO> getAllStudent(){
        return null;
    }

    public void deleteStudent( Long id){
        return;
    }

}
