package com.example.demo.services;

import com.example.demo.model.UserTwo;
import com.example.demo.repo.UserTwoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsServiceBean")
public class Users implements UserDetailsService{


    @Autowired
    UserTwoRepo userTwoRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserTwo user = userTwoRepo.findByName(userName);
        if (user == null) {
            return null;
        }
        List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        if (userName.equals("admin")) {
            auth = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        }
        String password = user.getPassword();
        return new User(userName, password, auth);


    }
}
