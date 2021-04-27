package com.chemcool.school.answers.service;

import com.chemcool.school.answers.domain.ChemFixedCorrectAnswers;
import com.chemcool.school.answers.storage.ChemFixedCorrectAnswersRepository;
import com.chemcool.school.answers.domain.fixedanswer.ChemFixedAnswerTask;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChemFixedCorrectAnswersService {
    private final ChemFixedCorrectAnswersRepository repository;

    public void saveCorrectAnswers(ChemFixedAnswerTask task) {
        repository.save(ChemFixedCorrectAnswers.createChemFixedCorrectAnswers(task));
    }

    public String getCorrectAnswerByIdTask(String taskId) {
        ChemFixedCorrectAnswers сorrectAnswers = repository.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Нет задачи с таким id"));
        return сorrectAnswers.getCorrectAnswer();
    }
}
