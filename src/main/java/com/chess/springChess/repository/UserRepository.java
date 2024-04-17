package com.chess.springChess.repository;

import com.chess.springChess.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsernameAndPassword(String username, String password);
}
