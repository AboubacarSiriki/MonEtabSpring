package ci.digitalacademy.monetab.services.mapper;


import ci.digitalacademy.monetab.models.Note;
import ci.digitalacademy.monetab.services.dto.NoteDTO;

public final class NoteMapper {

    private NoteMapper(){

    }

    public static NoteDTO toDto(Note note){
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(note.getId());
        noteDTO.setNote(note.getNote());
        noteDTO.setMatiere(note.getMatiere());
        return noteDTO;
    }

    public static Note toEntity(NoteDTO noteDTO){
        Note note = new Note();
        note.setId(noteDTO.getId());
        note.setNote(noteDTO.getNote());
        note.setMatiere(noteDTO.getMatiere());
        return note;
    }
}
