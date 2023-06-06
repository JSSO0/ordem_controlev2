package com.example.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springsecurity.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
