package com.radheankit.SpringDataJpa.repositories;

import com.radheankit.SpringDataJpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
