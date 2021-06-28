package com.chemcool.school.lesson.domain.matches;

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
@Table(name = "chem_matching_task_event")
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs(
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
)
public class ChemMatchingTaskEvent {

    @Id
    @Column(name = "chemistry_matching_task_event_id")
    private String chemistryMatchingTaskEventId;

    @Column(name = "chemistry_matching_task_event_author_id")
    private String chemistryMatchingTaskEventAuthorId;

    @Column(name = "chemistry_matching_task_event_occurring_context")
    private String chemistryMatchingTaskEventOccurringContext;

    @Column(name = "chemistry_matching_task_event_occurring_context_time")
    private LocalDateTime chemistryMatchingTaskEventOccurringContextTime;

    @Column(name = "chemistry_matching_task_event_type")
    private String chemistryMatchingTaskEventType;

    @Column(name = "version")
    private String version;

    @Column(name = "chemistry_matching_task_event_entity_id")
    private String chemistryMatchingTaskEventEntityId;


    @Type(type = "jsonb")
    @Column(name = "chemistry_matching_task_event_payload", columnDefinition = "jsonb")
    private ChemMatchingTask chemistryMatchingTaskEventPayload;


    public static ChemMatchingTaskEvent createEvent(ChemMatchingTask task, String authorId, ChemMatchingTaskEventType type){
        return new ChemMatchingTaskEvent(
                UUID.randomUUID().toString(),
                authorId,
                "ChemistryMatchingTaskEvent",
                LocalDateTime.now(),
                type.toString(),
                "1.0",
                task.getTaskId(),
                task
        );
    }
}
