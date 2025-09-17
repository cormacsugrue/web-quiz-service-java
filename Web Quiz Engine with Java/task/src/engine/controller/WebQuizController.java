package engine.controller;

import engine.model.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class WebQuizController {
    final Quiz quiz;

    public WebQuizController() {
        String[] options = {"Robot", "Tea leaf", "Cup of coffe", "Bug"};
        quiz = new Quiz("The Java Logo", "What is depicted on the Java Logo?", options);
    }

    @GetMapping("/quiz")
    public Quiz requestQuiz() {
        return quiz;
    }

    @PostMapping("/quiz")
    public ResponseEntity<?> submitAnswer(@RequestParam("answer") int answer) {

        if (answer < 0 || answer >= quiz.getOptions().length) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "The answer provided is out of bounds!"));
        }

        else if (answer == 2) {
            return ResponseEntity.ok(new QuizResponse(true, "Congratulations, you're right!"));
        }
        else
            return ResponseEntity.ok(new QuizResponse(false, "Wrong answer! Please, try again."));
    }


}
