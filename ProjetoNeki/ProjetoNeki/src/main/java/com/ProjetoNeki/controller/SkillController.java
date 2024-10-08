package com.ProjetoNeki.controller;

import com.ProjetoNeki.dto.SkillDto;
import com.ProjetoNeki.repository.SkillRepository;
import com.ProjetoNeki.service.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    SkillService skillService;

    @Operation(summary = "list all skills")
    @GetMapping
    public ResponseEntity<List<SkillDto>> listar() {
        return ResponseEntity.ok(skillService.listarSkills());
    }

}