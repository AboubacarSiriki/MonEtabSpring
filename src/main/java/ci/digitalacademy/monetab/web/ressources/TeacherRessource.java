package ci.digitalacademy.monetab.web.ressources;


import ci.digitalacademy.monetab.services.TeacherService;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/teachers")
public class TeacherRessource {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherDTO> saveTeacher( @RequestBody TeacherDTO teacherDTO){
        log.debug("Rest Request to save {}", teacherDTO);
        return new ResponseEntity<>(teacherService.save(teacherDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public TeacherDTO updateStudent( @RequestBody TeacherDTO teacherDTO, @PathVariable Long id){
        log.debug(" REST Request to update  {}", teacherDTO);
        return teacherService.update(teacherDTO, id);
    }

}
