package com.istore.istoreproject.Impl;

import org.springframework.stereotype.Service;

import com.istore.istoreproject.Services.QuestionService;
import com.istore.istoreproject.models.Question;
import com.istore.istoreproject.repositories.QuestionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo questionRepo;

    @Override
    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(long id, Question question) {
        Question question2 = questionRepo.findById(id).orElseThrow();
        question2.setQuestionText(question.getQuestionText());
        return questionRepo.save(question2);
    }

    @Override
    public void deleteQuestion(long id) {
        questionRepo.deleteById(id);
    }

    @Override
    public Question getById(long id) {
        return questionRepo.findById(id).orElseThrow();
    }

}
