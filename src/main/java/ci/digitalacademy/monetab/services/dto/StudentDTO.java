package ci.digitalacademy.monetab.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class StudentDTO extends PersonnDTO {

    private String matricule;

    private String classe;

    private LocalDate datenaiss;

    private Integer age;
}
