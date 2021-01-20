package com.chemcool.school.tasks.web.api.matching.dto;

import com.chemcool.school.tasks.domain.ChemistryMatchingTask;
import com.chemcool.school.tasks.domain.CoupleForMatching;
import com.chemcool.school.tasks.domain.TypeOfTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChemistryMatchingTaskDto {
    private String chemistryMatchingTaskUuid;
    private String description;
    private String chapterId;
    private TypeOfTask typeOfTask;
    private List<CoupleForMatching> coupleForMatchingList;

    public ChemistryMatchingTaskDto(ChemistryMatchingTask task) {
        this.chemistryMatchingTaskUuid = task.getChemistryMatchingTaskUuid();
        this.description = task.getDescription();
        this.chapterId = task.getChapterId();
        this.typeOfTask = task.getTypeOfTask();
        this.coupleForMatchingList = task.getCoupleForMatchingList();
    }

}
