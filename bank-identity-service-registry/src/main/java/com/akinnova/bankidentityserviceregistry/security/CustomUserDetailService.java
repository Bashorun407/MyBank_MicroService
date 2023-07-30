package com.akinnova.bankidentityserviceregistry.security;

import com.akinnova.bankidentityserviceregistry.entity.UserEntity;
import com.akinnova.bankidentityserviceregistry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("User with email: %s does exist", email)));

        //I do not know if subsequent code will work
        Set<GrantedAuthority> authorities = user.getRoles().stream()
                .map((role)-> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());

        return new User(user.getEmail(), user.getPassword(), authorities);
    }

}
