package ci.digitalacademy.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class FicheNoteDTO {

    private Long id;

    private String note;

    private Instant annee;

}
