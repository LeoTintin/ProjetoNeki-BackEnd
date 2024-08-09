package com.ProjetoNeki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ProjetoNeki.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
    boolean existsByUsuarioname(String username);
}
