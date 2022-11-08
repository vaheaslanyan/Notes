package com.urartusoftware.reactor.repositories;

import com.urartusoftware.reactor.daos.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Integer> {
    Optional<UserDAO> findById(int userId);
}
