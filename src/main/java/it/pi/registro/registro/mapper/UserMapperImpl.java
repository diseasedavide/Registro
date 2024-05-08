package it.pi.registro.registro.mapper;

import it.pi.registro.registro.configuration.RegistroProp;
import it.pi.registro.registro.dto.UserDTO;
import it.pi.registro.registro.dto.UserSubjectDTO;
import it.pi.registro.registro.dto.request.UserVotesRequest;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.entity.Subject;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.entity.UserDetail;
import it.pi.registro.registro.entity.UserSubjects;
import it.pi.registro.registro.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class UserMapperImpl implements UserMapper{

    @Autowired
    private RegistroProp registroProp;

    @Override
    public UserDTO toDTO(User user) {

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());

        UserDetail userDetail = new UserDetail();
        userDetail.setAddress(user.getUserDetail().getAddress());
        userDetail.setCity(user.getUserDetail().getCity());
        userDetail.setId(user.getUserDetail().getId());
        dto.setUserDetail(userDetail);

        return dto;
    }

    @Override
    public UserDataResponseDTO toDataResponseDTO(User user) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Period period =
                user.getDateOfBirth() != null ? Period.between(user.getDateOfBirth() , LocalDate.now()) : null;

        UserDataResponseDTO userDataResponseDTO =  new UserDataResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth()!= null ? user.getDateOfBirth().format(formatter) : "",
               0,
                period != null ? period.getYears() : 0,
                user.getEmail(),
                user.getUserDetail()!=null && user.getUserDetail().getAddress() != null ? user.getUserDetail().getAddress() : "NO ADDRESS",
                user.getUserDetail()!=null && user.getUserDetail().getCity() != null ? user.getUserDetail().getCity() : "NO CITY",
                user.getUserType()!=null && user.getUserType().getDescription()!=null ? user.getUserType().getDescription() : "NO DESCR",
                new ArrayList<>(),
                user.getActiveClass()
        );

        user.getUserSubjects()
                .forEach(userSubjects -> {
                    userDataResponseDTO
                            .getVotes()
                            .add(
                                    new UserSubjectDTO(
                                            userSubjects.getSubject().getName(),
                                            userSubjects.getSubject().getDescription(),
                                            userSubjects.getTeacher().getFirstName() + " " +
                                                    userSubjects.getTeacher().getLastName() + " " +
                                                    userSubjects.getTeacher().getEmail(),
                                            userSubjects.getVote(),
                                            userSubjects.getNotes(),
                                            userSubjects.getVote_date()
                                    )
                            );
        });
        return userDataResponseDTO;
    }

    @Override
    public UserVotesRequest toVoteRequestDTO(UserVotesRequest userVotesRequest) {
        if (userVotesRequest.getStartDate() == null && userVotesRequest.getEndDate() == null) {
            return new UserVotesRequest(
                    getStartDate(),
                    getEndDate(),
                    3L
            );
        } else if (userVotesRequest.getStartDate() == null || userVotesRequest.getEndDate() == null) {
            throw new BadRequestException("Both dates must be null or set");
        } else if (userVotesRequest.getStartDate().isAfter(userVotesRequest.getEndDate())) {
            throw new BadRequestException("Start date cannot be after end date");
        }

        return userVotesRequest;
    }


    private LocalDateTime getStartDate(){
        return LocalDateTime.now();
    }

    private LocalDateTime getEndDate(){
        return LocalDateTime.now();
    }


}
