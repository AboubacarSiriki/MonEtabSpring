package ci.digitalacademy.monetab.services.mapper;


import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.services.dto.StudentDTO;

public final class StudentMapper {

    private StudentMapper(){

    }

    public static StudentDTO toDto(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setNom(student.getNom());
        studentDTO.setPrenom(student.getPrenom());
        studentDTO.setMatricule(student.getMatricule());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setTelephone(student.getTelephone());
        studentDTO.setGenre(student.getGenre());
        studentDTO.setAge(student.getAge());
        studentDTO.setDatenaiss(student.getDatenaiss());
        studentDTO.setClasse(student.getClasse());
        studentDTO.setVille(student.getVille());
        return studentDTO;
    }

    public static Student toEntity(StudentDTO studentDTO){
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setNom(studentDTO.getNom());
        student.setPrenom(studentDTO.getPrenom());
        student.setMatricule(studentDTO.getMatricule());
        student.setEmail(studentDTO.getEmail());
        student.setTelephone(studentDTO.getTelephone());
        student.setGenre(studentDTO.getGenre());
        student.setAge(studentDTO.getAge());
        student.setDatenaiss(studentDTO.getDatenaiss());
        student.setClasse(studentDTO.getClasse());
        student.setVille(studentDTO.getVille());
        return student;
    }
}
