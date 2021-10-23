package com.chemcool.school.constructor.convertor;

import com.chemcool.school.constructor.domain.FixedAnswerTask;
import com.chemcool.school.constructor.representation.FixedAnswerDtoRepresentation;
import com.chemcool.school.tasks.statuses.TaskStatus;
import com.chemcool.school.tasks.statuses.TaskType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FixedAnswerModelConverterImp implements FixedAnswerDtoConverter{

    public FixedAnswerTask convertToTask(FixedAnswerDtoRepresentation fixedAnswerDtoRepresentation) {
       return FixedAnswerTask.builder()
               .taskId(UUID.randomUUID().toString())
               .conditionOfTask(fixedAnswerDtoRepresentation.getConditionOfTask())
               .classNum(fixedAnswerDtoRepresentation.getClassNum())
               .chapterNum(fixedAnswerDtoRepresentation.getChapterNum())
               .paragraphNum(fixedAnswerDtoRepresentation.getParagraphNum())
               .taskStatus(TaskStatus.CREATE)
               .taskType(TaskType.FIXED_ANSWER)
               .isHidden(false)
               .build();
    }
}
