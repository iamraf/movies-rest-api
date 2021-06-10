package io.github.iamraf.moviesrestapi.controllers;

import io.github.iamraf.moviesrestapi.entities.UserRequest;
import io.github.iamraf.moviesrestapi.exceptions.InvalidUsernameOrPasswordException;
import io.github.iamraf.moviesrestapi.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
public class AuthenticationController {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationController(JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody UserRequest userRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
        } catch (Exception ex) {
            throw new InvalidUsernameOrPasswordException("Invalid username or password");
        }

        return jwtUtils.generateToken(userRequest.getUsername());
    }
}
