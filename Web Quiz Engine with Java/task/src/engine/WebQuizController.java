package engine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebQuizController {
    final Quiz quiz;

    public WebQuizController() {
        String[] options = {"Robot", "Tea leaf", "Cup of coffe", "Bug"};
        quiz = new Quiz("The Java Logo", "What is depicted on the Java Logo?", options);
    }

    @GetMapping("/api/quiz")
    public Quiz requestQuiz() {
        return quiz;
    }

}
