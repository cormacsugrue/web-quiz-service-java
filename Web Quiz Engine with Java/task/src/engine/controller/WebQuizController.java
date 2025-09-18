package engine.controller;

import engine.model.Quiz;
import engine.repository.QuizRepository;
import jakarta.websocket.server.PathParam;
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

    // Post request to save a new quiz
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/quizzes")
    public Quiz create(@RequestBody Quiz quiz) {
        return repository.save(quiz);
    }

    // Post request to solve a quiz by its id

    @PostMapping("/quizzes/{id}/solve")
    public QuizResponse answer(@PathVariable("id") int id, @RequestParam("answer") int answer) {
        Optional<Quiz> opt = repository.findById(id);
        if (opt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Quiz not found");
        }

        Quiz quiz = opt.get();
        if (answer == quiz.getAnswer()) return new QuizResponse(true, "Congratulations, you're right!");
        else return new QuizResponse(false, "Wrong answer! Please, try again.");
    }

}
