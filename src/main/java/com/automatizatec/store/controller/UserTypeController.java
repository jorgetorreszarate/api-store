package com.automatizatec.store.controller;

import com.automatizatec.store.dto.UserTypeResponseDTO;
import com.automatizatec.store.service.UserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/roles")
@RequiredArgsConstructor
public class UserTypeController {
    private final UserTypeService userTypeService;

    @GetMapping
    public List<UserTypeResponseDTO> getAll() {
        return userTypeService.findAll();
    }
}
