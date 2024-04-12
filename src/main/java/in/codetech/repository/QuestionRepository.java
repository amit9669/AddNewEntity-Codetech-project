package in.codetech.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.codetech.model.exam.Quiz;
import in.codetech.model.exam.Question;

@Repository
public interface  QuestionRepository extends JpaRepository<Question,Long>{
	
	Set<Question> findByQuiz(Quiz quiz);

}
