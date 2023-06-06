package com.example.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.springsecurity.model.Usuario;

public interface UserService extends UserDetailsService {
    Usuario save(Usuario usuario);
}