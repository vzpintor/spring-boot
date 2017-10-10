package com.example.demo.controller;

import com.example.demo.Util.HeaderUtil;
import com.example.demo.services.UserService;
import com.example.demo.services.dto.ManagedUser;
import com.example.demo.services.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author vzpintor
 * @project demo
 * @date 10/10/17
 */

@RestController
@RequestMapping("/api")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private static final String ENTITY_NAME = "user";

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) throws URISyntaxException {
        log.debug("Creating user");

        UserDTO user = userService.createUser(userDTO);

        if (user.getEmail() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "emailExist", "A new usuario cannot already have an Email")).body(null);

        } else if (userService.findByEmail(userDTO.getEmail())) {
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "emailexists", "Email already in use"))
                    .body(null);
        }


        UserDTO result = userService.createUser(userDTO);

        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, userDTO.getEmail()))
                .body(result);

    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        log.debug("obtaining users");

        return userService.getAllUsers();
    }
}
