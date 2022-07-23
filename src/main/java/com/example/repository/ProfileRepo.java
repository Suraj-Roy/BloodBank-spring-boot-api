package com.example.repository;

import com.example.entity.ProfileEntity;
import java.util.List;

import com.example.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface ProfileRepo extends JpaRepository<ProfileEntity,Long> {

    @Query("from ProfileEntity p where p.Blood_Group=:bg")
    List<ProfileEntity> findByBlood_Group(String bg);

    @Query("from ProfileEntity p where p.City=:city")
    List<ProfileEntity> findByCity(String city);
}
