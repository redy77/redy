package com.chemcool.school.lesson.web.api.service;

import com.chemcool.school.lesson.web.api.dto.ChemEquationsTaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ChemEquationsTaskPresentation {

    private final ChemEquationsTaskServiceLayer serviceLayer;

    public List<ChemEquationsTaskDto> getAllChemistryEquationsDto() {
        return serviceLayer.getAllChemEquationsDto();
    }

    public List<ChemEquationsTaskDto> getAllChemistryEquationsByReferenceIdDto(Integer referenceId) {
        return serviceLayer.getAllChemEquationsByReferenceIdDto(referenceId);
    }

    public List<ChemEquationsTaskDto> getAllChemistryEquationsByChapterIdDto(Integer chapterId) {
        return serviceLayer.getAllChemEquationsByChapterIdDto(chapterId);
    }
    public List<ChemEquationsTaskDto> getAllChemistryEquationsByReferenceIdAndChapterIdDto(Integer referenceId,Integer chapterId) {
        return serviceLayer.getAllByReferenceIdAndChapterIdDto(referenceId,chapterId);
    }

    public ChemEquationsTaskDto getEquationsTaskById(String id) {
        return serviceLayer.getChemEquationsTaskById(id);
    }

    public ChemEquationsTaskDto getRandomChemistryEquationsDto() {
        return serviceLayer.getRandomChemistryEquationsDto();
    }
}