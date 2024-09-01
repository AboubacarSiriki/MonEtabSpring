package ci.digitalacademy.monetab.services.impl;

import ci.digitalacademy.monetab.models.Address;
import ci.digitalacademy.monetab.repositories.AdresseRepository;
import ci.digitalacademy.monetab.services.AdresseService;
import ci.digitalacademy.monetab.services.dto.AddressDTO;
import ci.digitalacademy.monetab.services.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service

public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        log.debug("Resqurst to save : {}",addressDTO);
        Address address = AddressMapper.toEntity(addressDTO);
        address= adresseRepository.save(address);

        return  AddressMapper.toDto(address);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {

//        Address address = AddressMapper.toEntity(addressDTO);
//        address = adresseRepository.save(address);
//
//        return AddressMapper.toDto(address);

        return findOne(addressDTO.getId()).map(existingAddress ->{
            existingAddress.setCountry(addressDTO.getCountry());
            existingAddress.setCity(addressDTO.getCity());
            return save(existingAddress);
        }).orElseThrow(() -> new IllegalArgumentException());
    }

    @Override
    public Optional<AddressDTO> findOne(Long id) {

        return adresseRepository.findById(id).map(address -> {
            return AddressMapper.toDto(address);
        });
    }

    @Override
    public List<AddressDTO> findAll() {

        return adresseRepository.findAll().stream().map(address -> {
            return AddressMapper.toDto(address);
        }).toList();
    }

    @Override
    public void delecte(Long id) {

    }
}
