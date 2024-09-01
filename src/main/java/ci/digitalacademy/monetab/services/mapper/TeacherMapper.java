package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.Student;
import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.services.dto.StudentDTO;
import ci.digitalacademy.monetab.services.dto.TeacherDTO;

public final class TeacherMapper {

    private TeacherMapper(){

    }

    public static TeacherDTO toDto(Teacher teacher){
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setNom(teacher.getNom());
        teacherDTO.setPrenom(teacher.getPrenom());
        teacherDTO.setMatiere(teacher.getMatiere());
        teacherDTO.setEmail(teacher.getEmail());
        teacherDTO.setTelephone(teacher.getTelephone());
        teacherDTO.setGenre(teacher.getGenre());
        teacherDTO.setVacant(teacher.getVacant());
        teacherDTO.setVille(teacher.getVille());
        return teacherDTO;
    }

    public static Teacher toEntity(TeacherDTO teacherDTO){
        Teacher teacher  = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setNom(teacherDTO.getNom());
        teacher.setPrenom(teacherDTO.getPrenom());
        teacher.setMatiere(teacherDTO.getMatiere());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setTelephone(teacherDTO.getTelephone());
        teacher.setGenre(teacherDTO.getGenre());
        teacher.setVacant(teacherDTO.getVacant());
        teacher.setVille(teacherDTO.getVille());
        return teacher;
    }
}
