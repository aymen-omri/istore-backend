package com.istore.istoreproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.istore.istoreproject.models.Question;


public interface QuestionRepo extends JpaRepository<Question , Long> {
    
}
