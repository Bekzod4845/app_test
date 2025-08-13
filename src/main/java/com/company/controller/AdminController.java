package com.company.controller;

import com.company.model.Question;
import com.company.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final QuestionService questionService;

    public AdminController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public String listQuestions(Model model) {
        model.addAttribute("questions", questionService.findAll());
        return "admin/questions";
    }

    @GetMapping("/questions/new")
    public String newQuestion(Model model) {
        model.addAttribute("question", new Question());
        return "admin/question_form";
    }

    @PostMapping("/questions")
    public String saveQuestion(@ModelAttribute Question question) {
        questionService.save(question);
        return "redirect:/admin/questions";
    }

    @GetMapping("/questions/edit/{id}")
    public String editQuestion(@PathVariable Long id, Model model) {
        model.addAttribute("question", questionService.getById(id));
        return "admin/question_form";
    }

    @GetMapping("/questions/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.delete(id);
        return "redirect:/admin/questions";
    }
}
