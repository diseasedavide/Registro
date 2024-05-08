package it.pi.registro.registro.dto.request;

import it.pi.registro.registro.enums.UserTypeEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserVotesRequest {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @NotNull
    private Long userId;

    @Override
    public String toString() {
        return "UserVotesRequest{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", userId=" + userId +
                '}';
    }
}
