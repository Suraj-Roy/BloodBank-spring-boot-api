package com.example.repository;

import com.example.entity.BloodGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BloodGroupRepo extends JpaRepository<BloodGroups,Long> {


    BloodGroups findByGroupsample(String name);
}
