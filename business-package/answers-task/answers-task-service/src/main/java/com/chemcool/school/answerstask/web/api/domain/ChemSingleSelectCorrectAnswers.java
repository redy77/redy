package com.chemcool.school.answerstask.web.api.domain;

import com.chemcool.school.answerstask.tasks.chemsingleselect.domain.ChemSingleSelectTask;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "cmemesingleselect_correct_answers")
public class ChemSingleSelectCorrectAnswers extends AbstractBaseCorrectAnswersClass{

    public ChemSingleSelectCorrectAnswers(String taskId, String rightAnswer) {
        super(taskId, rightAnswer);
    }

    public static ChemSingleSelectCorrectAnswers createChemSingleSelectCorrectAnswers(ChemSingleSelectTask task) {
        return new ChemSingleSelectCorrectAnswers(task.getTaskId(), task.getCorrectAnswer());
    }
}
