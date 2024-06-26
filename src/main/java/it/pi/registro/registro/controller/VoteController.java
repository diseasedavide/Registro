package it.pi.registro.registro.controller;

import it.pi.registro.registro.dto.request.VoteAssignRequestDTO;
import it.pi.registro.registro.service.VoteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/votes")
public class VoteController {

    private VoteService voteService;

    @PostMapping
    public ResponseEntity<?> assignVote(@Valid @RequestBody VoteAssignRequestDTO voteAssignRequestDTO){
        try {
            return new ResponseEntity<>(voteService.assignVote(voteAssignRequestDTO), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
