package in.codetech.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import in.codetech.model.exam.Question;
import in.codetech.model.exam.Quiz;


@Service
public interface QuestionService {
	
	


    public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestions();
	
	public Question getQuestion(Long questionId);
	
	public Set<Question> getQuestionsOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long quesId);

}
