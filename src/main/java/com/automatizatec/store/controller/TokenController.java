package com.automatizatec.store.controller;

import com.automatizatec.store.dto.TokenRequestDTO;
import com.automatizatec.store.dto.TokenResponseDTO;
import com.automatizatec.store.dto.UserSingleResponseDTO;
import com.automatizatec.store.service.UserService;
import com.automatizatec.store.utils.JwtUtil;
import com.automatizatec.store.utils.PasswordEncoderUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/token")
public class TokenController {
    private final UserService userService;
    private final PasswordEncoderUtil passwordEncoderUtil;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public TokenController(UserService userService, PasswordEncoderUtil passwordEncoderUtil, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoderUtil = passwordEncoderUtil;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<?> getToken(@RequestBody TokenRequestDTO tokenRequestDTO) throws Exception {
        Optional<UserSingleResponseDTO> user = userService.findSingleById(tokenRequestDTO.username());

        if (user.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "User not found"));
        }

        UserSingleResponseDTO userEntity = user.get();

        if (!passwordEncoderUtil.verifyPassword(tokenRequestDTO.password(), userEntity.getPassword())) {
            return ResponseEntity.badRequest().body(Map.of("message", "Password invalid"));
        }

        String token = jwtUtil.generateToken(userEntity);

        TokenResponseDTO tokenResponse = TokenResponseDTO
                .builder()
                .accessToken(token)
                .build();

        return ResponseEntity.ok(tokenResponse);
    }
}
