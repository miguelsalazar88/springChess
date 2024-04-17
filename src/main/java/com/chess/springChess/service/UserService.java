package com.chess.springChess.service;

import com.chess.springChess.entitiy.User;
import com.chess.springChess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String email, String password) {
        if (username == null || password == null) {
            return null;
        } else {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            return userRepository.save(user);
        }
    }

    public User autenticate(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

}
