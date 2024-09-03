package ci.digitalacademy.monetab.services;

import ci.digitalacademy.monetab.services.dto.AppSettingDTO;
import ci.digitalacademy.monetab.services.dto.RoleUserDTO;
import ci.digitalacademy.monetab.services.dto.SchoolDTO;
import ci.digitalacademy.monetab.services.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface AppSettingService {

    AppSettingDTO save(AppSettingDTO appSettingDTO);

    AppSettingDTO update(AppSettingDTO appSettingDTO);

    Optional<AppSettingDTO> findOne(Long id);

    List<AppSettingDTO> findAll();

    void delecte(Long id);

    List<AppSettingDTO> findAllBySmtpUserName(String smtpuserneme );

    AppSettingDTO initApp(AppSettingDTO appSettingDTO);

    AppSettingDTO existingParameter();

    SchoolDTO initSchool(SchoolDTO schoolDTO, AppSettingDTO appSettingDTO);

    List<RoleUserDTO> initRoles(List<RoleUserDTO> roleUserDTO);

    void initUsers(List<UserDTO> userDTOS, List<RoleUserDTO> roleUserDTO, SchoolDTO schoolDTO);



}
