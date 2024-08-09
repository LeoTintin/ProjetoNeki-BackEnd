package com.ProjetoNeki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ProjetoNeki.dto.LoginRequest;
import com.ProjetoNeki.dto.RegisterRequest;
import com.ProjetoNeki.repository.UsuarioRepository;
import com.ProjetoNeki.security.JwtTokenProvider;
import com.ProjetoNeki.service.UserDetailsServiceImpl;
import com.ProjetoNeki.model.Usuario;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Autowired
    private UserDetailsServiceImpl UsuarioDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtTokenProvider.generateToken(authentication);

            return ResponseEntity.ok(new JwtResponse(jwt));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        if (UsuarioRepository.existsByUsuarioname(registerRequest.getUsuarioname())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuarioname is already taken");
        }

        Usuario Usuario = new Usuario();
        Usuario.setUsername(registerRequest.getUsuarioname());
        Usuario.setPassword(UsuarioDetailsService.encodePassword(registerRequest.getPassword()));

        UsuarioRepository.save(Usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registered successfully");
    }
}
