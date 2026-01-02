package org.example.apitestingwitherrorthrowing.Repositories;

import org.example.apitestingwitherrorthrowing.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
