package kz.sprint.techboot.sprint.controller;

import kz.sprint.techboot.sprint.model.Student;
import kz.sprint.techboot.sprint.repository.StudentRepository;
import kz.sprint.techboot.sprint.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/")
    public String indexPage(Model model,
                            @RequestParam(name = "key", required = false, defaultValue = "") String key){
        model.addAttribute("students", studentService.getStudents(key));
        return "index";
    }

    @PostMapping(value = "/add-student")
    public String addGame(Student student){
        studentService.addStudent(student);
        return "redirect:/";
    }

    @GetMapping(value = "/add-student")
    public String addGamePage(Model model){
        return "addStudent";
    }

}
