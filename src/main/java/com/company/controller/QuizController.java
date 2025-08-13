package com.company.controller;

import com.company.model.Question;
import com.company.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/quiz")
public class QuizController {

    private final QuestionService questionService;

    public QuizController(QuestionService questionService) {
        this.questionService = questionService;
    }



    @GetMapping("/start")
    public String startQuiz(Model model) {
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);
        return "quiz/quiz";
    }

    @PostMapping("/submit")
    public String submitQuiz(@RequestParam Map<String, String> formData, Model model) {
        List<Question> questions = questionService.findAll();
        int correctCount = 0;

        for (Question q : questions) {
            String userAnswer = formData.get("q_" + q.getId());
            if (q.getCorrectAnswer().equalsIgnoreCase(userAnswer)) {
                correctCount++;
            }
        }

        double percentage = (correctCount * 100.0) / questions.size();

        model.addAttribute("correctCount", correctCount);
        model.addAttribute("total", questions.size());
        model.addAttribute("percentage", percentage);

        return "quiz/result";
    }
}
