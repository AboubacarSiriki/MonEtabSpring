package ci.digitalacademy.monetab.repositories;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.User;
import ci.digitalacademy.monetab.models.enumeration.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //    etape 1)
    List<Student> findByNomIgnoreCaseOrMatriculeIgnoreCaseAndGenre(String prenom, String matricule , String genre);
}
