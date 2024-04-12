package in.codetech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.codetech.model.exam.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long>{

}
