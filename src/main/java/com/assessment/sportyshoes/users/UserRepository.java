package com.assessment.sportyshoes.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> getUserByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE user_role=:user",nativeQuery = true)
    List<User> getRegisteredUsers(@Param("user") String user);
}
