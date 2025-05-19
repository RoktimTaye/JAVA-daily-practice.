package com.roktim.Security.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SpringSecurityCustomUserDetails implements UserDetailsService
{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //3.loadusername ko autheenticationmanager use karta hain user ko load karne kee liye UserDetailService ka use karke .User kma username yaha ayega
                              //4.Ab user load karne ke bad ye user details firse security context holder ke pass jaega, uske bad security filterchain ke pas jaega.
        if(!username.equals("roktim"))// or if condition me check hoga match kar raha hain ki nahi
        {
            throw new UsernameNotFoundException("user not found");
        }
            String encodepass = new BCryptPasswordEncoder().encode("root"); //encoder main store kiya
        return User
                .withUsername("roktim").password(encodepass) //encoder pass kiya
                .roles("USER") //user ka role he bataya
                .build(); //pura build config me return kar diya
    }
}
