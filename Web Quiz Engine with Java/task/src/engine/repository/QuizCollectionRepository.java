package engine.repository;


import engine.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class QuizCollectionRepository implements QuizRepository {
    private final List<Quiz> quizList = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    public QuizCollectionRepository() {
    }

    public Optional<Quiz> findById(Integer id) {
        return quizList.stream().filter(quiz -> quiz.getId().equals(id))
                .findFirst();
    }

    public List<Quiz> findAll() {
        return quizList;
    }

    public void save(Quiz quiz) {
        if (quiz.getId() == null) {
            quiz.setId(counter.incrementAndGet());
        }
        quizList.add(quiz);
    }


}
