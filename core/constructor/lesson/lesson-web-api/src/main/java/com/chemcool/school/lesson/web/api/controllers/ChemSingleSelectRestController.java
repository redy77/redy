package com.chemcool.school.lesson.web.api.controllers;

import com.chemcool.school.lesson.web.api.dto.ChemSingleSelectTaskDto;
import com.chemcool.school.lesson.web.api.service.ChemSingleSelectTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping({"chemSingleSelect/v1.0"})
@RequiredArgsConstructor
public class ChemSingleSelectRestController {
    private final ChemSingleSelectTaskPresentation presentation;

    @GetMapping
    @ApiOperation("Возвращает все задания типа \"Выбор одного ответа\" по химии.")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemSingleSelectTaskDto> getAllTasks() {
        return presentation.getAllTasksDto();
    }

    @ApiOperation("Возвращает сущности задания типа \"Один ответ\" по главе")
    @GetMapping("/findSingleSelectTaskByChapterId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemSingleSelectTaskDto> findTaskByChapterId(@PathVariable("id") Integer chapterId){
        return presentation.getAllTasksByChapterIdDto(chapterId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Один ответ\" по разделу")
    @GetMapping("/findSingleSelectTaskByReferenceId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemSingleSelectTaskDto> findTaskByReferenceId(@PathVariable("id") Integer referenceId){
        return presentation.getAllTasksByReferenceIdDto(referenceId);
    }

    @ApiOperation("Возвращает сущности задания типа \"Один ответ\" по разделу и главе")
    @GetMapping("/findSingleSelectTaskByReferenceId/{reference_id}/AndChapterId/{chapter_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ChemSingleSelectTaskDto> findTaskByReferenceIdAndChapterId(
            @PathVariable("reference_id") Integer referenceId,
            @PathVariable("chapter_id") Integer chapterId) {
        return presentation.getAllTasksByReferenceIdAndChapterIdDto(referenceId, chapterId);
    }

    @GetMapping("/{uuid}")
    @ApiOperation("Возвращает дто сущности задания типа \"Выбор одного ответа\" по химии по UUID.")
    @ResponseStatus(HttpStatus.OK)
    public ChemSingleSelectTaskDto getTaskById(@PathVariable String uuid) {
        return presentation.getTaskDtoByIdDto(uuid);
    }

    @GetMapping("/randomTask")
    @ApiOperation("Возвращает случайную сущность задания типа \"Уравнения\"")
    @ResponseStatus(HttpStatus.OK)
    public ChemSingleSelectTaskDto getRandomTask() {
        return presentation.getRandomChemSingleSelectTaskDto();
    }
}
