package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.UserCreateRequestDTO;
import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.dto.response.UserInfoResponseDTO;
import it.pi.registro.registro.entity.User;

import java.util.List;

public interface VoteService {

    User assignVote(VoteAssignRequestDTO voteAssignRequestDTO);

}
