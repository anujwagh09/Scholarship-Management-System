package com.example.scholarship.repo;
import com.example.scholarship.model.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ScholarshipRepo extends JpaRepository<Scholarship, Long> { }
