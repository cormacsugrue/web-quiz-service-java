package engine.controller;

import engine.model.Quiz;
import engine.repository.QuizRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WebQuizController {
//    final Quiz quiz;
    private final QuizRepository repository;

    public WebQuizController(QuizRepository repository) {
        this.repository = repository;
    }

    // Endpoint to get all quizes in the repoistiory
    @GetMapping("/quizzes")
    public List<Quiz> findAll() {
        return repository.findAll();
    }


}
