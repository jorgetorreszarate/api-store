package com.automatizatec.store.controller;

import com.automatizatec.store.dto.UserTypeResponseDTO;
import com.automatizatec.store.service.UserTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-types")
public class UserTypeController {
    private final UserTypeService userTypeService;

    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping
    public ResponseEntity<List<UserTypeResponseDTO>> getAll() {
        List<UserTypeResponseDTO> lstUserTypes = userTypeService.findAll();
        return ResponseEntity.ok(lstUserTypes);
    }
}
