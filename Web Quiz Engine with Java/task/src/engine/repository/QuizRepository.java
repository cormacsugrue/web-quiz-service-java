package engine.repository;

import engine.model.Quiz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface QuizRepository extends CrudRepository<Quiz,Integer> {

    Optional<Quiz> findById(Integer id);

    List<Quiz> findAll();

    Quiz save(Quiz quiz);
}
