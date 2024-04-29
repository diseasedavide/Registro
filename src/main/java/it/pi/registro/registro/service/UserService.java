package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.UserCreateRequestDTO;
import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.entity.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public interface UserService {

    User createUser(User user);

    User createUserWithDetails(UserCreateRequestDTO userCreateRequestDTO);

    User getUserById(Long userId);

    List<User> getUsersWithoutDetails();

    User getUserByEmail(String email);

    UserInfoResponseDTO getUserInfoByEmail(UserInfoRequestDTO userInfoRequestDTO);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);

}
