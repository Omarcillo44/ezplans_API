package com.ezsoftware.ezplans.Repository;

import com.ezsoftware.ezplans.Model.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCelularUsuario(String celularUsuario);
}
