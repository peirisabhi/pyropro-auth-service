package com.hour14.pyropro.pyroproauthservice.repository;

import com.hour14.pyropro.pyroproauthservice.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {


}
