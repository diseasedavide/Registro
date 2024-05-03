package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.dto.request.UserCreateRequestDTO;
import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.request.UserVotesRequest;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.dto.response.UserVotesResponse;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserDetail;
import it.pi.registro.registro.entity.UserSubjects;
import it.pi.registro.registro.entity.UserType;
import it.pi.registro.registro.enums.UserTypeEnum;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.repository.UserSubjectRepository;
import it.pi.registro.registro.repository.UserTypeRepository;
import it.pi.registro.registro.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    @Value("${registro.vote.month.start}")
    private String voteStartDate;

    @Value("${registro.vote.month.end}")
    private String voteEndDate;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private UserRepository userRepository;
    private UserTypeRepository userTypeRepository;
    private UserSubjectRepository userSubjectRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User createUserWithDetails(UserCreateRequestDTO userCreateRequestDTO) {

        User user = new User();
        user.setFirstName(userCreateRequestDTO.getFirstName());
        user.setLastName(userCreateRequestDTO.getLastName());
        user.setEmail(userCreateRequestDTO.getEmail());
        user.setPassword(userCreateRequestDTO.getPassword());

        UserDetail userDetail  = new UserDetail();
        userDetail.setAddress(userCreateRequestDTO.getAddress());
        userDetail.setCity(userCreateRequestDTO.getCity());

        UserType userType = userTypeRepository.findByType(UserTypeEnum.GUEST.toString());

        if(userCreateRequestDTO.getType() != null ){
            userType = userTypeRepository.findByType(userCreateRequestDTO.getType().toString());
        }
        user.setUserDetail(userDetail);
        user.setUserType(userType);
        userRepository.save(user);

        return user;
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getUsersWithoutDetails() {
        return userRepository.findUsersWhereDetailIsNull();
    }

    @Override
    public UserInfoResponseDTO getUserInfoByEmail(UserInfoRequestDTO userInfoRequestDTO) {
        User user = userRepository.findByEmail(userInfoRequestDTO.getUserEmail());
        return new UserInfoResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getUserType().getDescription()
        );
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("getAllUsers");
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser =  userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserVotesResponse getUserVotes(UserVotesRequest userVotesRequest) throws Exception {

        logger.info(String.valueOf(voteStartDate));


        for (
                UserSubjects userSubjects:
                userSubjectRepository
                        .findVotesByRange(
                                userVotesRequest.getStartDate(),
                                userVotesRequest.getEndDate(),
                                userVotesRequest.getUserId())
        ){
            logger.info("Vote" + userSubjects.getVote());
            logger.info("Materia" + userSubjects.getSubject().getName());
            logger.info("Teacher" + userSubjects.getTeacher().getLastName() + " - " + userSubjects.getTeacher().getFirstName());
        }


        return null;
    }
}


