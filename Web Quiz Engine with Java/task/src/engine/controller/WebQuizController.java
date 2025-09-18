package engine.controller;

import engine.model.Quiz;
import engine.repository.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class WebQuizController {
//    final Quiz quiz;
    private final QuizRepository repository;

    public WebQuizController(QuizRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/quizzes")
    public List<Quiz> findAll() {
        return repository.findAll();
    }


    // Request for quiz with given id
    @GetMapping("/quizzes/{id}")
    public Quiz findById(@PathVariable("id") Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found"));
    }


}
