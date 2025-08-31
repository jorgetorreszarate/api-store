package com.automatizatec.store.controller;

import com.automatizatec.store.dto.PersonalRequestDTO;
import com.automatizatec.store.dto.PersonalResponseDTO;
import com.automatizatec.store.entity.PersonalEntity;
import com.automatizatec.store.service.PersonalService;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/personal")
@Validated
@RequiredArgsConstructor
public class PersonalController {
    private final PersonalService personalService;

    @GetMapping
    public ResponseEntity<List<PersonalResponseDTO>> getAllActives() throws Exception {
        List<PersonalResponseDTO> lstPersonal = personalService.findAll();
        return ResponseEntity.ok(lstPersonal);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PersonalResponseDTO>> search(
            @RequestParam
            @Pattern(regexp = "^$|^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$", message = "Solo se permiten letras y espacios")
            String value
    ) throws Exception {
        List<PersonalResponseDTO> lstPersonal = personalService.search(value);
        return ResponseEntity.ok(lstPersonal);
    }

    @GetMapping("/paging")
    public ResponseEntity<Page<PersonalResponseDTO>> findAllCustomPagingEntity(
            @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
    ) {
        try {
            Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
            Page<PersonalResponseDTO> personal = personalService.findAllCustomPagingEntity(pageRequest);
            if (personal.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(personal);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{personalId}")
    public ResponseEntity<?> getById(@PathVariable int personalId) {
        try {
            Optional<PersonalResponseDTO> personalResponseDTO = personalService.findById(personalId);

            if (personalResponseDTO.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(personalResponseDTO.get());

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PersonalRequestDTO personalRequestDTO) {
        try {
            int personalId = personalService.save(personalRequestDTO);
            return ResponseEntity.ok(personalId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{personalId}")
    public ResponseEntity<?> delete(@PathVariable int personalId) {
        try {
            boolean res = personalService.delete(personalId);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
