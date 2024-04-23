package it.pi.registro.registro.mapper;

import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDataResponseDTO toDataResponseDTO(User user);
}
