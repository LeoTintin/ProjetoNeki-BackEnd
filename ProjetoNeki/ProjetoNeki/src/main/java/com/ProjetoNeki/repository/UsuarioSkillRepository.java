package com.ProjetoNeki.repository;

import com.ProjetoNeki.model.Skill;
import com.ProjetoNeki.model.UsuarioSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioSkillRepository extends JpaRepository<UsuarioSkill, Long> {
    @Query(value = "SELECT us.usuario_id,us.skill_id, us.id, us.level\n" +
            "FROM usuarios u\n" +
            "JOIN usuarios_skills us ON u.id = us.usuario_id\n" +
            "JOIN skills s ON s.id = us.skill_id\n" +
            "WHERE u.id = :id;",nativeQuery = true)
    List<UsuarioSkill> findAllSkillsByUserId(Long id);
}