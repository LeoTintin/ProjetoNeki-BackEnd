package com.ProjetoNeki.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String Username;

    @Column(nullable = false)
    private String Password;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioSkill> usuarioSkills;

    public Usuario() {
    }

    public Usuario(Long id, String Username, String Password) {
        this.id = id;
        this.Username = Username;
        this.Password = Password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}