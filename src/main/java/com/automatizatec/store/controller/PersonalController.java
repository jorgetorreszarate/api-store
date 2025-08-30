package com.automatizatec.store.controller;

import com.automatizatec.store.dto.PersonalResponseDTO;
import com.automatizatec.store.service.PersonalService;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personal")
@Validated
public class PersonalController {

    private final PersonalService personalService;

    public PersonalController(PersonalService personalService) {
        this.personalService = personalService;
    }

    @GetMapping
    public ResponseEntity<List<PersonalResponseDTO>> getAllActives() throws Exception {
        List<PersonalResponseDTO> lstPersonal = personalService.findAll();
        return ResponseEntity.ok(lstPersonal);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PersonalResponseDTO>> search(
            @RequestParam
            @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$", message = "Solo se permiten letras y espacios")
            String value
    ) throws Exception {
        List<PersonalResponseDTO> lstPersonal = personalService.search(value);
        return ResponseEntity.ok(lstPersonal);
    }
}
