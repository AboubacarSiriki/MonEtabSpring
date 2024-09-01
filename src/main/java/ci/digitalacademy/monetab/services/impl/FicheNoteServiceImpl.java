package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.repositories.FicheRepository;
import ci.digitalacademy.monetab.services.FicheService;
import ci.digitalacademy.monetab.services.dto.FicheNoteDTO;
import ci.digitalacademy.monetab.services.mapper.AddressMapper;
import ci.digitalacademy.monetab.services.mapper.FicheNoteMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FicheNoteServiceImpl implements FicheService
{
    private final FicheRepository ficheRepository;

    @Override
    public FicheNoteDTO save(FicheNoteDTO ficheNoteDTO) {
        log.debug("Resqurst to save : {}",ficheNoteDTO);
        FicheNote ficheNote = FicheNoteMapper.toEntity(ficheNoteDTO);
        ficheNote= ficheRepository.save(ficheNote);

        return  FicheNoteMapper.toDto(ficheNote);
    }

    @Override
    public FicheNoteDTO update(FicheNoteDTO ficheNoteDTO) {
        //FicheNote ficheNote = FicheNoteMapper.toEntity(ficheNoteDTO);
//        address = adresseRepository.save(address);
//
//        return AddressMapper.toDto(address);

        return findOne(ficheNoteDTO.getId()).map(existingFicheNote ->{
            existingFicheNote.setNote(ficheNoteDTO.getNote());
            existingFicheNote.setAnnee(ficheNoteDTO.getAnnee());
            return save(existingFicheNote);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<FicheNoteDTO> findOne(Long id) {
        return ficheRepository.findById(id).map(ficheNote -> {
            return FicheNoteMapper.toDto(ficheNote);
        });
    }

    @Override
    public List<FicheNoteDTO> findAll() {
        return ficheRepository.findAll().stream().map(ficheNote -> {
            return FicheNoteMapper.toDto(ficheNote);
        }).toList();
    }

    @Override
    public void delecte(Long id) {

    }
}
