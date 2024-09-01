package ci.digitalacademy.monetab.services.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonnDTO {


    private Long id;

    private String nom;

    private String prenom;

    private String telephone;

    private String ville;

    private String email;

    private String genre;
}
