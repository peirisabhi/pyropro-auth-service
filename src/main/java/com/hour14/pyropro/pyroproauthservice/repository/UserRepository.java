package com.hour14.pyropro.pyroproauthservice.repository;

import com.hour14.pyropro.pyroproauthservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByStatus(int status);

}
