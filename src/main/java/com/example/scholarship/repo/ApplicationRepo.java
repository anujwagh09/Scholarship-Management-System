package com.example.scholarship.repo;
import com.example.scholarship.model.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ApplicationRepo extends JpaRepository<ApplicationEntity, Long> { }
