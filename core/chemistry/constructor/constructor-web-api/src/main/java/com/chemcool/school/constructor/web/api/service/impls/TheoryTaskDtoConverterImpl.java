package com.chemcool.school.constructor.web.api.service.impls;

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.constructor.domain.representation.TheoryTaskRepresentation;
import com.chemcool.school.constructor.web.api.dto.TheoryTaskDto;
import com.chemcool.school.constructor.web.api.service.TheoryTaskDtoConverter;
import org.springframework.stereotype.Service;

/**
 * @Author : Constantine Lee
 * @Date : 26.10.2021
 * @e-mail : rhowbn@gmail.com
 */
@Service
public class TheoryTaskDtoConverterImpl implements TheoryTaskDtoConverter {

    @Override
    public TheoryTaskRepresentation convertToRepresentation(TheoryTaskDto dto) {
        return TheoryTaskRepresentation.builder()
                .conditionOfTask(dto.getConditionOfTask())
                .classNum(dto.getClassNum())
                .chapterNum(dto.getChapterNum())
                .paragraphNum(dto.getParagraphNum())
                .theoryText(dto.getTheoryText())
                .build();
    }
}
