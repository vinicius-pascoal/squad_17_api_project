package com.squad_17_api.demo.controller;
import com.squad_17_api.demo.controller.RestController;
import com.squad_17_api.demo.model.Aluno; // Importação da classe Aluno
import com.squad_17_api.demo.service.AlunoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AuthService;
import model.AuthenticationResponse;
import model.LoginRequest;
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        AuthenticationResponse authenticationResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(authenticationResponse);
    }
}