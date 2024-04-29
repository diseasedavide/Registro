package it.pi.registro.registro.mapper;

import it.pi.registro.registro.dto.UserSubjectDTO;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.entity.User;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDataResponseDTO toDataResponseDTO(User user) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Period period =

                user.getDateOfBirth()!=null ? Period.between(user.getDateOfBirth(), LocalDate.now()) : null;

        //TODO: LocalDate nextBirtday = ChronoUnit.MONTHS.addTo(user.getDateOfBirth(),365);

        UserDataResponseDTO userDataResponseDTO = new UserDataResponseDTO(
                user.getFirstName(),
                user.getLastName(),
                user.getDateOfBirth() != null ? user.getDateOfBirth().format(formatter) : "",
                //TODO:ChronoUnit.DAYS.between(user.getDateOfBirth(),nextBirtday),
                0,
                period != null ? period.getYears() : 0,
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
