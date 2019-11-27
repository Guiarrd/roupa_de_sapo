package com.projetoFinal.centralErros.service;

import com.projetoFinal.centralErros.model.User;
import com.projetoFinal.centralErros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(name).orElseThrow(() -> new UsernameNotFoundException("Nenhum usuário encontrado."));
    List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
    return new org.springframework.security.core.userdetails.User
            (user.getEmail(), user.getPassword(), authorityListUser);
  }
}
