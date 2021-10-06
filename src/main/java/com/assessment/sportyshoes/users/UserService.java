package com.assessment.sportyshoes.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.getUserByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("username with email %s not found",email)));
    }


    public void registerNewUser(User user){

        if(userRepository.getUserByEmail(user.getEmail()).isPresent()){
            throw new IllegalStateException("email already exists");
        }

        String userPassword = user.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(userPassword);
        user.setPassword(encodedPassword);

        userRepository.save(user);

    }

    public List<User> getAllUsers(){
        return userRepository.getRegisteredUsers("USER");
    }

}
