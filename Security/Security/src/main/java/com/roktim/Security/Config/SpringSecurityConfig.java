package com.roktim.Security.Config;

import com.roktim.Security.Service.SpringSecurityCustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private SpringSecurityCustomUserDetails springSecurityCustomUserDetails;//Yaha custom user details config kee sath connected hoga.
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception //1.Sabse pahle controller se yaha request ayega.
    {
        httpSecurity.authorizeHttpRequests(request->request
                .requestMatchers("/","contactUs","aboutUs").permitAll() //Matcher ke Request ko permit kar do
                .anyRequest().authenticated() //matcher ke alawa kisi vhi disre request ko authenticate kar do
        ).formLogin(Customizer.withDefaults()); //Rquest formlogin me ayega
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder1(){ //Custom PasswordEncoder method jo password leta hain

        return new BCryptPasswordEncoder(); //password encode karke Authentication block me de deta hain
    }

    @Bean
    public AuthenticationManager authenticationManager (HttpSecurity httpSecurity) throws Exception //2.Yaha pe request ati hain next(Authentication block)
    { //authenticationManager is the authentication reference provider for AuthenticationManager.
        //Starting-->Yaha se authenticationProvider start hua hain,or ye userDtailService se connect karte hain.
        AuthenticationManagerBuilder builder=
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class); //httpSecurity AuthenticationManagerBuilder
                                             // ko bol raha hain ki uske andar ka AuthenticationManagerBuilder dene ke liiye
                builder.userDetailsService(springSecurityCustomUserDetails) //userDetailService me batana hain konnsa UserDetailservice class se user lena hain
                        .passwordEncoder(passwordEncoder1()); //passwordEncoder meain batana hain ki is custom PasswordEncoder method se password lena hain
        return builder.build(); //Final AuthenticationManager banake return kar deta hain Spring Security ko
        //Finish-->Yaha authenticationProvider khatam hua hain.
    }

}
