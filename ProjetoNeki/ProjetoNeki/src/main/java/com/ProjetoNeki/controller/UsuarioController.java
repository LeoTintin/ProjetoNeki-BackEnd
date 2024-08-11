package com.ProjetoNeki.controller;

import com.ProjetoNeki.dto.UsuarioSkillRequestDto;
import com.ProjetoNeki.dto.UsuarioSkillResponseDto;
import com.ProjetoNeki.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/skills/{id}")
    public ResponseEntity<List<UsuarioSkillResponseDto>>findAllSkillsByUserId(@PathVariable Long id){
        return ResponseEntity.ok(skillService.findAllSkillsByUserId(id));
    }

    @PostMapping("/skills")
    public ResponseEntity<UsuarioSkillResponseDto>atribuirSkill(@RequestBody UsuarioSkillRequestDto dto){
        return ResponseEntity.ok(skillService.atribuirSkill(dto));
    }
}