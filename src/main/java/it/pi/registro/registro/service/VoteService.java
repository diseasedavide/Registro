package it.pi.registro.registro.service;

import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.dto.response.VoteAssignResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface VoteService {

    VoteAssignResponseDTO assignVote(VoteAssignRequestDTO voteAssignRequestDTO) throws Exception;

}
