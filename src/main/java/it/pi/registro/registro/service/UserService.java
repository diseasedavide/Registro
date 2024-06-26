package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.UserCreateRequestDTO;
import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.request.UserVotesRequest;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.dto.response.UserVotesResponse;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);

    User createUserWithDetails(UserCreateRequestDTO userCreateRequestDTO);

    User getUserById(Long userId);

    List<User> getUsersWithoutDetails();

    UserInfoResponseDTO getUserInfoByEmail(UserInfoRequestDTO userInfoRequestDTO);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);

    UserVotesResponse getUserVotes(UserVotesRequest userVotesRequest)
            throws ResourceNotFoundException, BadRequestException;

}
