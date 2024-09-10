package ci.digitalacademy.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TeacherDTO extends PersonnDTO {

    private String matiere;

    private Boolean vacant;

    private PersonnDTO personnDTO;

    private Set<FicheNoteDTO> ficheNoteDTOS;
}
