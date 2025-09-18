package engine.repository;


import engine.model.Quiz;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class QuizCollectionRepository implements QuizRepository {
    private final List<Quiz> quizList = new ArrayList<>();

    public QuizCollectionRepository() {
    }

    public Optional<Quiz> findById(int id) {
        return quizList.stream().filter(quiz -> quiz.getId().equals(id))
                .findFirst();
    }

    public List<Quiz> findAll() {
        return quizList;
    }

    public void save(Quiz quiz) {
        quizList.add(quiz);
    }


}
