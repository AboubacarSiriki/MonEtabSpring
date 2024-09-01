package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTO extends PersonnDTO {

    private String matiere;

    private Boolean vacant;

    private  TeacherDTO teacherDTO;
}
