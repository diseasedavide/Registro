package it.pi.registro.registro.controller;

import it.pi.registro.registro.annotation.NotZeroAndPositive;
import it.pi.registro.registro.dto.request.UserCreateRequestDTO;
import it.pi.registro.registro.dto.request.UserDelete;
import it.pi.registro.registro.dto.request.UserInfoRequestDTO;
import it.pi.registro.registro.dto.request.UserVotesRequest;
import it.pi.registro.registro.dto.response.UserDataResponseDTO;
import it.pi.registro.registro.dto.response.UserVotesResponse;
import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.exception.BadRequestException;
import it.pi.registro.registro.exception.ResourceNotFoundException;
import it.pi.registro.registro.mapper.UserMapper;
import it.pi.registro.registro.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Validated
@RequestMapping("api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserDataResponseDTO>> getAllUsers() {

        String info = "messaggio di info";
        logger.info("getAllUsers - {}", info);

        return new ResponseEntity<>(
                userService.getAllUsers()
                .stream()
                .map(userMapper::toDataResponseDTO)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUserInfo(@Valid @RequestBody UserInfoRequestDTO userInfoDTO){
        try{
            return new ResponseEntity<>(userService.getUserInfoByEmail(userInfoDTO), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> deleteUserById(
            @PathVariable("id") @NotZeroAndPositive Long userId,
            @Valid @RequestBody UserDelete userDelete
    ){
        userService.deleteUser(userId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }


    @GetMapping("/userVotes/{id}")
    public ResponseEntity<UserVotesResponse> getUserVotes(@Valid @RequestBody UserVotesRequest userVotesRequest){
            userService.getUserVotes(userVotesRequest);

        return null;
        //return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Create simple user without details
     */
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * Create user with details
     */
    @PostMapping("/withDetails")
    public ResponseEntity<User> createUserWithDetails(@Valid @RequestBody UserCreateRequestDTO userCreateRequestDTO){
        User savedUser = userService.createUserWithDetails(userCreateRequestDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        User updatedUser = userService.getUserById(userId);
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        userService.updateUser(updatedUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
