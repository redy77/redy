package com.chemcool.school.tasks.web.api.dto;

/**
 * @Author Constantine Lee
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SingleSelectDto {

    private String taskId;

    @NotNull
    private String conditionOfTask;

    @NotNull
    @NotBlank
    private String rightAnswer;

    @NotNull
    @Size(min = 3)
    private List<String> answers;

    @NotNull
    @Range(min = 1, max = 11, message = "класс (от 1 до 11)")
    private Short classNum;

    @NotNull
    @Range(min = 1, max = 4, message = "глава (от 1 до 4)")
    private Short chapterNum;

    @NotNull
    @Range(min = 1, max = 100, message = "параграф (от 1 до 100)")
    private Short paragraphNum;
}