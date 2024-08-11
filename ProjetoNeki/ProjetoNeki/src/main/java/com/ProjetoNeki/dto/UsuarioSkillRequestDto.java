package com.ProjetoNeki.dto;

import com.ProjetoNeki.model.LevelSkill;

public class UsuarioSkillRequestDto {

    private Long usuarioId;
    private Long skillId;
    private LevelSkill level;

    public UsuarioSkillRequestDto(Long usuarioId, Long skillId, LevelSkill level) {
        this.usuarioId = usuarioId;
        this.skillId = skillId;
        this.level = level;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public LevelSkill getLevel() {
        return level;
    }
}