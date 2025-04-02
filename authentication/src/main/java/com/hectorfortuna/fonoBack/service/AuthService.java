package com.hectorfortuna.fonoBack.service;


import com.hectorfortuna.fonoBack.dto.AuthRequest;
import com.hectorfortuna.fonoBack.dto.AuthResponse;
import com.hectorfortuna.fonoBack.dto.RegisterRequest;
import com.hectorfortuna.fonoBack.enums.Role;
import com.hectorfortuna.fonoBack.model.User;
import com.hectorfortuna.fonoBack.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return new AuthResponse(jwtService.generateToken(user));
    }

    public AuthResponse authenticate(AuthRequest request) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()));

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        return new AuthResponse(jwtService.generateToken(user));
    }
}
