package it.pi.registro.registro.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class RegistroProp {

    @Value("${registro.vote.month.start}")
    private int voteStartDate;

    @Value("${registro.vote.month.end}")
    private String voteEndDate;

}
