package ci.digitalacademy.monetab.services.mapper;

import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.services.dto.FicheNoteDTO;

public final class FicheNoteMapper {

    private FicheNoteMapper(){

    }
    public static FicheNoteDTO toDto(FicheNote ficheNote){
        FicheNoteDTO ficheNoteDTO = new FicheNoteDTO();
        ficheNoteDTO.setId(ficheNote.getId());
        ficheNoteDTO.setNote(ficheNote.getNote());
        ficheNoteDTO.setAnnee(ficheNote.getAnnee());
        return ficheNoteDTO;
    }

    public static FicheNote toEntity(FicheNoteDTO ficheNoteDTO){
        FicheNote ficheNote = new FicheNote();
        ficheNote.setId(ficheNoteDTO.getId());
        ficheNote.setNote(ficheNoteDTO.getNote());
        ficheNote.setAnnee(ficheNoteDTO.getAnnee());
        return ficheNote;
    }
}
