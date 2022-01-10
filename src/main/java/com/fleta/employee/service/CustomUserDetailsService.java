package com.fleta.employee.service;

import com.fleta.employee.entity.SecurityUser;
import com.fleta.employee.entity.User;
import com.fleta.employee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLoginId(username);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException(username + " : 사용자 존재하지 않음");
        }

        return new SecurityUser(user.get());
    }
}
