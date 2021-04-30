package com.chemcool.school.answers.storage.singleselect;

import com.chemcool.school.answers.domain.singleselect.ChemSingleSelectCorrectAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemSingleSelectCorrectAnswerRepository extends JpaRepository<ChemSingleSelectCorrectAnswers, String> {
}
