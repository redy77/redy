package com.chemcool.school.answers.storage;

import com.chemcool.school.answers.domain.ChemmathesCorrectAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemmathesCorrectAnswersRepository extends JpaRepository<ChemmathesCorrectAnswers, String> {
}