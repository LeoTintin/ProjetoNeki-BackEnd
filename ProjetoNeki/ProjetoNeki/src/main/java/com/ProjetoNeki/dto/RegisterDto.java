package com.ProjetoNeki.dto;

import com.ProjetoNeki.model.UsuarioRole;

public record RegisterDto(String login, String password, UsuarioRole role) {
}