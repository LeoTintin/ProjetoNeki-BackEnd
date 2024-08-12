package com.ProjetoNeki.dto;

import com.ProjetoNeki.Enum.UsuarioRole;

public record RegisterDto(String login, String password, UsuarioRole role) {
}