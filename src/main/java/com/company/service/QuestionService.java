package com.company.service;

import com.company.model.Question;
import com.company.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository repo;

    public QuestionService(QuestionRepository repo) {
        this.repo = repo;
    }

    public List<Question> findAll() {
        return repo.findAll();
    }

    public Question save(Question q) {
        return repo.save(q);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Question getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
