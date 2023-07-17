package com.springsecurity.security.services;

import com.springsecurity.security.entities.MyUser;
import com.springsecurity.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * cette classe implémente interface UserDetailsService. L’interface UserDetailsService est
 * utilisée pour récupérer les données liées à l’utilisateur. Il a une méthode nommée
 * loadUserByUsername qui trouve une entité utilisateur basée sur le nom d’utilisateur
 * et peut être substituée pour personnaliser le processus de recherche de l’utilisateur.
 * Il est utilisé par DaoAuthenticationProvider pour charger des détails sur l’utilisateur
 * lors de l’authentification
 */
@Service
@Scope("singleton")
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public CustomUserService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Objects.requireNonNull(username);
        MyUser user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user;
    }
}
