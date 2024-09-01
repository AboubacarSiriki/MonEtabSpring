package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Note;
import ci.digitalacademy.monetab.repositories.NoteRepository;
import ci.digitalacademy.monetab.services.NoteService;
import ci.digitalacademy.monetab.services.dto.NoteDTO;
import ci.digitalacademy.monetab.services.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;


    @Override
    public NoteDTO save(NoteDTO noteDTO) {
        log.debug("Resqurst to save : {}",noteDTO);
        Note note = NoteMapper.toEntity(noteDTO);
        note= noteRepository.save(note);

        return  NoteMapper.toDto(note);
    }

    @Override
    public NoteDTO update(NoteDTO noteDTO) {
          //Note note = NoteMapper.toEntity(noteDTO);
//        address = adresseRepository.save(address);
//
//        return AddressMapper.toDto(address);

        return findOne(noteDTO.getId()).map(existingNote ->{
            existingNote.setNote(noteDTO.getNote());
            existingNote.setMatiere(noteDTO.getMatiere());
            return save(existingNote);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<NoteDTO> findOne(Long id) {
        return noteRepository.findById(id).map(note -> {
            return NoteMapper.toDto(note);
        });
    }

    @Override
    public List<NoteDTO> findAll() {
        return noteRepository.findAll().stream().map(note -> {
            return NoteMapper.toDto(note);
        }).toList();
    }

    @Override
    public void delecte(Long id) {

    }
}
