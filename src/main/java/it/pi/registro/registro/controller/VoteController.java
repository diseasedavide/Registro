package it.pi.registro.registro.controller;

import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.service.VoteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("api/votes")
public class VoteController {

    private VoteService voteService;

    @PostMapping
    public ResponseEntity<?> assignVote(@Valid @RequestBody VoteAssignRequestDTO voteAssignRequestDTO) {
        System.out.println(voteAssignRequestDTO);
        return null;
    }
}
