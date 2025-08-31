package com.automatizatec.store.controller;

import com.automatizatec.store.dto.UserPasswordRequestDTO;
import com.automatizatec.store.dto.UserRequestDTO;
import com.automatizatec.store.dto.UserResponseDTO;
import com.automatizatec.store.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/by-personal/{personalId}")
    public ResponseEntity<List<UserResponseDTO>> findAllByPersonal(@PathVariable int personalId) throws Exception {
        try {
            List<UserResponseDTO> users = userService.findAllByPersonal(personalId);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public @ResponseBody ResponseEntity<?> findById(@RequestParam String userId) {
        try {
            Optional<UserResponseDTO> userResponseDTO = userService.findById(userId);

            if (userResponseDTO.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(userResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserRequestDTO userRequestDTO) {
        try {
            Optional<UserResponseDTO> userEntity = userService.findById(userRequestDTO.getUserId());

            if (userEntity.isPresent()) {
                return ResponseEntity
                        .badRequest()
                        .body(Map.of("message", "Usuario ya existe"));
            }

            UserResponseDTO resUserEntity = userService.save(userRequestDTO);

            if (resUserEntity == null) {
                return ResponseEntity
                        .badRequest()
                        .body(Map.of("message", "Error al registrar usuario"));
            }

            URI location = null;
            return ResponseEntity.created(location).body(resUserEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<UserResponseDTO> update(@RequestBody UserRequestDTO userRequestDTO) {
        try {
            UserResponseDTO resUserEntity = userService.update(userRequestDTO);

            if (resUserEntity == null) {
                return ResponseEntity.badRequest().build();
            }

            return ResponseEntity.ok(resUserEntity);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PatchMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody UserPasswordRequestDTO userPasswordRequestDTO) {
        try {
            boolean response = userService.updatePassword(userPasswordRequestDTO);

            if (!response) {
                return ResponseEntity.badRequest().body(Map.of("message", "Your password not been update"));
            }

            return ResponseEntity.ok().body(Map.of("message", "Password update"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String userId) {
        try {
            userService.delete(userId);
            return ResponseEntity.ok().body(Map.of("message", "User deleted"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("message", e.getMessage()));
        }
    }
}
