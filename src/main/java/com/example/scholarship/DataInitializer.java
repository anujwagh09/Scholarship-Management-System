package com.example.scholarship;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.scholarship.model.Scholarship;
import com.example.scholarship.model.Admin;
import com.example.scholarship.repo.ScholarshipRepo;
import com.example.scholarship.repo.AdminRepo;
@Component
public class DataInitializer implements CommandLineRunner {
    private final ScholarshipRepo repo;
    private final AdminRepo adminRepo;
    public DataInitializer(ScholarshipRepo r, AdminRepo ar){ this.repo = r; this.adminRepo = ar; }
    @Override
    public void run(String... args) throws Exception {
        if (repo.count()==0){
            Scholarship s1 = new Scholarship(); s1.setName("Merit Scholarship"); s1.setDescription("For top performers"); s1.setAmount(50000.0);
            Scholarship s2 = new Scholarship(); s2.setName("Need-based Scholarship"); s2.setDescription("For low income students"); s2.setAmount(30000.0);
            repo.save(s1); repo.save(s2);
        }
        if (adminRepo.count() == 0) {
            Admin a = new Admin(); a.setName("Super Admin"); a.setEmail("admin@example.com"); a.setPassword("admin123"); adminRepo.save(a);
        }
    }
}
