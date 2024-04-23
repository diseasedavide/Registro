package it.pi.registro.registro.mapper;

import it.pi.registro.registro.dto.UserSubjectDTO;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.entity.User;

import java.util.ArrayList;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDataResponseDTO toDataResponseDTO(User user) {

        UserDataResponseDTO userDataResponseDTO = new UserDataResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUserDetail() != null && user.getUserDetail().getAddress() != null ? user.getUserDetail().getAddress() : "",
                user.getUserDetail() != null && user.getUserDetail().getCity() != null ? user.getUserDetail().getCity() : "",
                user.getUserType()!= null && user.getUserType().getDescription() != null ? user.getUserType().getDescription() : "",
                new ArrayList<>()
        );
        user.getUserSubjects().forEach(
                userSubjects -> {
                    userDataResponseDTO
                            .getVotes()
                            .add(new UserSubjectDTO(
                                    userSubjects.getSubject().getName(),
                                    userSubjects.getSubject().getDescription(),
                                    userSubjects.getTeacher().getFirstName() + " " +
                                    userSubjects.getTeacher().getLastName() + " " +
                                    userSubjects.getTeacher().getEmail(),
                                    userSubjects.getVote(),
                                    userSubjects.getNotes(),
                                    userSubjects.getVote_date()
                            ));
                });

        return userDataResponseDTO;
    }
}
