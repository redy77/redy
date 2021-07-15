package com.chemcool.school.tasks.controllers.chemmatches;

import com.chemcool.school.tasks.dto.chemmatches.ChemistryMatchingTaskDto;
import com.chemcool.school.tasks.service.chemmatches.ChemistryMatchingTaskPresentation;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v.1.0/chemistryMatching")
@RequiredArgsConstructor
public class ChemistryMatchingTaskRestController {
    private final ChemistryMatchingTaskPresentation presentation;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Создает новую сущность задания типа \"matching(сопоставления)\" по химии.")
    @ResponseBody
    public String createNewTask(@RequestHeader(value = "Authorization") String token,
                                @RequestBody ChemistryMatchingTaskDto task) {
        return presentation.add(task, token);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Обновляет существующую сущность задания типа \"matching(сопоставления)\" по химии.")
    @ResponseBody
    public String updateTask(@RequestBody ChemistryMatchingTaskDto task) {
        presentation.update(task);
        return "Update task UUID: " + task.getTaskId();
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Удалеят существующую сущность задания типа \"matching(сопоставления)\" по химии по UUID.")
    public String deleteTask(@PathVariable String uuid) {
        presentation.deleteById(uuid);
        return "Сущность с UUID = " + uuid + " была успешно удалена.";
    }
}
