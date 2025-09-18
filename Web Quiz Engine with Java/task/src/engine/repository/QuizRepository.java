package engine.repository;

import engine.model.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizRepository {

    Optional<Quiz> findById(int id);

    List<Quiz> findAll();

    void save(Quiz quiz);
}
