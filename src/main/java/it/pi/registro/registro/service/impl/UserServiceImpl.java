package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.configuration.RegistroProp;
import it.pi.registro.registro.dto.request.UserCreateRequestDTO;
import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.request.UserVotesRequest;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.dto.response.UserVotesResponse;
import it.pi.registro.registro.entity.Attendance;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserDetail;
import it.pi.registro.registro.entity.UserType;
import it.pi.registro.registro.enums.UserTypeEnum;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import it.pi.registro.registro.mapper.UserMapper;
import it.pi.registro.registro.repository.AttendanceRepository;
import it.pi.registro.registro.repository.UserRepository;
import it.pi.registro.registro.repository.UserSubjectRepository;
import it.pi.registro.registro.repository.UserTypeRepository;
import it.pi.registro.registro.service.UserService;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private UserTypeRepository userTypeRepository;
    @Autowired
    private UserSubjectRepository userSubjectRepository;
    @Autowired
    private UserMapper userMapper;


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

        User user = userRepository.findById(userId).get();

        user.getStudentAttendances().forEach(attendance -> {
            attendance.setStudent(null);
            attendanceRepository.save(attendance);
        });

        user.getUserSubjects().forEach(userSubjects -> {
            userSubjects.setUser(null);
            userSubjectRepository.save(userSubjects);
        });

        userRepository.delete(user);


    }

    @Override
    public UserVotesResponse getUserVotes(UserVotesRequest userVotesRequest)
            throws ResourceNotFoundException, BadRequestException  {

       UserVotesRequest request = userMapper.toVoteRequestDTO(userVotesRequest);

       System.out.println(request);



        /*System.out.println(registroProp.getVoteEndDate());

        Optional<User> student = userRepository.findById(userVotesRequest.getUserId());

        if (student.isEmpty()) {
            throw new ResourceNotFoundException("User with id - " + userVotesRequest.getUserId() + " - Searched User not found");
        }
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
        }*/
    return null;
    }


    LocalDateTime getStartDate(LocalDateTime dtoStartDate){
        return LocalDateTime.now();
    }


}


