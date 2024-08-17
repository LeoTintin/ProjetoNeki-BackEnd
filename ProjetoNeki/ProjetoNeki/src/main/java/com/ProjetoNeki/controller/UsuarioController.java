package com.ProjetoNeki.controller;

import com.ProjetoNeki.dto.UsuarioSkillRequestDto;
import com.ProjetoNeki.dto.UsuarioSkillResponseDto;
import com.ProjetoNeki.service.SkillService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private SkillService skillService;

    @Operation(summary = "Skill list.")
    @GetMapping("/skills/{id}")
    public ResponseEntity<List<UsuarioSkillResponseDto>>findAllSkillsByUserId(@PathVariable Long id){
        return ResponseEntity.ok(skillService.findAllSkillsByUserId(id));
    }

    @Operation(summary = "Users skills")
    @PostMapping("/skills")
    public ResponseEntity<UsuarioSkillResponseDto>atribuirSkill(@RequestBody UsuarioSkillRequestDto dto){
        return ResponseEntity.ok(skillService.atribuirSkill(dto));
    }

    @Operation(summary = "Skill delete")
    @DeleteMapping("/skills/{usuarioId}/{skillId}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long usuarioId, @PathVariable Long skillId) {
        skillService.deleteSkill(usuarioId, skillId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Skill update")
    @PutMapping("/skills/{usuarioId}/{skillId}")
    public ResponseEntity<UsuarioSkillResponseDto> updateSkill(
            @PathVariable Long usuarioId,
            @PathVariable Long skillId,
            @RequestBody UsuarioSkillRequestDto dto) {
        return ResponseEntity.ok(skillService.updateSkill(usuarioId, skillId, dto));
    }

    @Operation(summary = "Skill list")
    @GetMapping("/skills")
    public ResponseEntity<List<UsuarioSkillResponseDto>> findAllSkills() {
        return ResponseEntity.ok(skillService.findAllSkills());
    }

}