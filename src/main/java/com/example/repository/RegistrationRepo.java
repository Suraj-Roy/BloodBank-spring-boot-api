package com.example.repository;

import com.example.entity.ProfileEntity;
import com.example.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepo extends JpaRepository<RegistrationEntity,Long> {


}
