package com.example.autentication.Services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.autentication.Models.User;
import com.example.autentication.Repositories.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        
        User user = userRepo.findByName(name)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with name: " + name));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
    
}
