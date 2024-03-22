package com.istore.istoreproject.Services;

import com.istore.istoreproject.models.Question;

public interface QuestionService {
    
    Question addQuestion(Question question);

    Question updateQuestion(long id, Question question);

    void deleteQuestion(long id);

    Question getById(long id);
}
