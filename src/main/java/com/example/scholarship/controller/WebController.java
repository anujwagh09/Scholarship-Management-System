package com.example.scholarship.controller;
import com.example.scholarship.model.*;
import com.example.scholarship.repo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;
@Controller
public class WebController {
    private final StudentRepo studentRepo;
    private final ScholarshipRepo scholarshipRepo;
    private final ApplicationRepo applicationRepo;
    public WebController(StudentRepo sr, ScholarshipRepo schr, ApplicationRepo ar){
        this.studentRepo = sr; this.scholarshipRepo = schr; this.applicationRepo = ar;
    }
    @GetMapping({"/","/index"}) public String index(){ return "index"; }
    @GetMapping("/register") public String registerForm(){ return "register"; }
    @PostMapping("/register") public String register(Student student, Model m){
        if (studentRepo.findByEmail(student.getEmail()).isPresent()){ m.addAttribute("error","Email already used"); return "register"; }
        studentRepo.save(student); return "redirect:/login?msg=registered";
    }
    @GetMapping("/login") public String loginForm(){ return "login"; }
    @PostMapping("/login") public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model m){
        var opt = studentRepo.findByEmail(email);
        if (opt.isPresent() && opt.get().getPassword().equals(password)){
            session.setAttribute("studentEmail", email); return "redirect:/dashboard";
        }
        m.addAttribute("error","Invalid credentials"); return "login";
    }
    @GetMapping("/dashboard") public String dashboard(HttpSession session, Model m){
        String email = (String) session.getAttribute("studentEmail"); if (email==null) return "redirect:/login"; m.addAttribute("email", email); return "dashboard";
    }
    @GetMapping("/scholarships") public String listScholarships(Model m){ List<Scholarship> list = scholarshipRepo.findAll(); m.addAttribute("list", list); return "scholarships"; }
    @PostMapping("/apply") public String apply(@RequestParam Long scholarshipId, HttpSession session, Model md){
        String email = (String) session.getAttribute("studentEmail"); if (email==null) return "redirect:/login";
        var student = studentRepo.findByEmail(email).orElse(null); if (student==null) return "redirect:/login";
        var sch = scholarshipRepo.findById(scholarshipId).orElse(null); if (sch==null) return "redirect:/scholarships";
        ApplicationEntity app = new ApplicationEntity(); app.setStudent(student); app.setScholarship(sch); applicationRepo.save(app);
        return "redirect:/dashboard";
    }
}
