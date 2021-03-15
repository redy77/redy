package com.chemcool.school.lesson.tasks.chemmatches.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs(
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
)
public class ChemistryMatchingTaskEvent {

    @Id
    private String chemistryMatchingTaskEventId;
    private String chemistryMatchingTaskEventAuthorId;
    private String chemistryMatchingTaskEventOccurringContext;
    private LocalDateTime chemistryMatchingTaskEventOccurringContextTime;
    private ChemistryMatchingTaskEventType chemistryMatchingTaskEventType;
    private String version;
    private String chemistryMatchingTaskEventEntityId;

    @Type(type = "jsonb")
    @Column(name = "chemistry_matching_task_event_payload", columnDefinition = "jsonb")
    private ChemistryMatchingTask chemistryMatchingTaskEventPayload;


    public static ChemistryMatchingTaskEvent createEvent(ChemistryMatchingTaskExample example){
        ChemistryMatchingTask task =
                ChemistryMatchingTaskFactory.createChemistryMatchingTask(example);
        return new ChemistryMatchingTaskEvent(
                UUID.randomUUID().toString(),
                "123",
                "ChemistryMatchingTaskEvent",
                LocalDateTime.now(),
                ChemistryMatchingTaskEventType.CREATED,
                "1.0",
                task.getTaskId(),
                task
        );
    }

}