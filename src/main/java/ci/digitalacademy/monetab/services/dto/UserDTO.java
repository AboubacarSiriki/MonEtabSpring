package ci.digitalacademy.monetab.services.dto;


import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.RoleUser;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
public class UserDTO {

    private Long id;

    private String speudo;

    private String password;

    private boolean active;

    private Instant creationdate;

    private AddressDTO adresseDTO;

    private SchoolDTO schoolDTO;

    private Set<AddressDTO> addressDTOS;

    private Set<RoleUserDTO> roleUserDTOS;

}
