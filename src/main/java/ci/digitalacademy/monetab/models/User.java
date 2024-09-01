package ci.digitalacademy.monetab.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",unique = true,nullable = false)
    private String speudo;

    @Column(name ="password",nullable = false)
    private String password;

    @Column(name = "create_date",nullable = false)
    private Instant creationdate;

    @OneToOne
    @JoinColumn(name = "adresseId")
    private Address adresse;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", speudo='" + speudo + '\'' +
                ", password='" + password + '\'' +
                ", creationdate=" + creationdate +
                ", adresse=" + adresse.getCountry() +
                '}';
    }
}
