package com.example.scholarship.controller;
import com.example.scholarship.model.ApplicationEntity;
import com.example.scholarship.repo.ApplicationRepo;
import com.example.scholarship.repo.AdminRepo;
import com.example.scholarship.model.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminRepo adminRepo;
    private final ApplicationRepo applicationRepo;
    public AdminController(AdminRepo adminRepo, ApplicationRepo applicationRepo){
        this.adminRepo = adminRepo; this.applicationRepo = applicationRepo;
    }
    @GetMapping("/login") public String loginForm(){ return "admin_login"; }
    @PostMapping("/login") public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model m){
        var opt = adminRepo.findByEmail(email);
        if (opt.isPresent() && opt.get().getPassword().equals(password)){
            session.setAttribute("adminEmail", email); return "redirect:/admin/apps";
        }
        m.addAttribute("error","Invalid credentials"); return "admin_login";
    }
    @GetMapping("/logout") public String logout(HttpSession session){ session.invalidate(); return "redirect:/admin/login"; }
    @GetMapping("/apps") public String apps(Model m, HttpSession session){
        if (session.getAttribute("adminEmail") == null) return "redirect:/admin/login";
        List<ApplicationEntity> apps = applicationRepo.findAll(); m.addAttribute("apps", apps); return "admin_apps";
    }
    @PostMapping("/apps/{id}/update") public String updateStatus(@PathVariable Long id, @RequestParam String action, @RequestParam(required=false) String remarks, HttpSession session){
        if (session.getAttribute("adminEmail") == null) return "redirect:/admin/login";
        applicationRepo.findById(id).ifPresent(app -> {
            if ("approve".equalsIgnoreCase(action)) app.setStatus("Approved");
            else if ("reject".equalsIgnoreCase(action)) app.setStatus("Rejected");
            app.setRemarks(remarks); applicationRepo.save(app);
        });
        return "redirect:/admin/apps";
    }
}
