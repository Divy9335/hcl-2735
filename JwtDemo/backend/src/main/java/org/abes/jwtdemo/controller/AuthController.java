package org.abes.jwtdemo.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.abes.jwtdemo.dto.AuthRequest;
import org.abes.jwtdemo.dto.AuthResponse;
import org.abes.jwtdemo.entity.User;
import org.abes.jwtdemo.repository.UserRepository;
import org.abes.jwtdemo.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthRequest req){
        if(userRepo.findByUsername(req.username()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Map.of("error","username is already in use")
            );
        }
        userRepo.save(new User(req.username(),passwordEncoder.encode(req.password())));
        return ResponseEntity.ok(Map.of("Message", "user registerd successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest req){
        var user = userRepo.findByUsername(req.username()).orElse(null);
        if(user==null || !passwordEncoder.matches(req.password(),user.getPassword())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Map.of("error","username or password is wrong")
            );
        }
        return ResponseEntity.ok(new AuthResponse(jwtService.generateToken(user.getUsername()),user.getPassword()));
    }
}
