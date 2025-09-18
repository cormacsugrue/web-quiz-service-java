package engine.repository;

import engine.model.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizRepository {

    Optional<Quiz> findById(Integer id);

    List<Quiz> findAll();

    Quiz save(Quiz quiz);
}
