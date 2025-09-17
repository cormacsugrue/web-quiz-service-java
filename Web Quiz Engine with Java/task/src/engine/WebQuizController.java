package engine;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("/api/quiz")
public class WebQuizController {
    final Quiz quiz;
    final QuizResponse correctAnswerResponse = new QuizResponse(true, "Congratulations, you're right!");
    final QuizResponse incorrectAnswerResponse= new QuizResponse(false, "Wrong answer! Please, try again.");

    public WebQuizController() {
        String[] options = {"Robot", "Tea leaf", "Cup of coffe", "Bug"};
        quiz = new Quiz("The Java Logo", "What is depicted on the Java Logo?", options);
    }

    @GetMapping("")
    public Quiz requestQuiz() {
        return quiz;
    }

    @PostMapping("")
    public ResponseEntity<?> submitAnswer(@RequestParam("answer") int answer) {

        if (answer < 0 || answer >= quiz.getOptions().length) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "The answer provided is out of bounds!"));
        }

        else if (answer == 2) {
            return ResponseEntity.ok(correctAnswerResponse);
        }

        return ResponseEntity.ok(incorrectAnswerResponse);

    }


}
