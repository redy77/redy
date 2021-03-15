package com.chemcool.school.auth.service.domain;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TypeDefs(
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
)
@Table(name = "users_registration_event")
public class RegisterUserEvent {

    @Id
    @Column(name = "user_registration_event_id")
    private String eventId;

    @Column(name = "user_registration_event_author_id")
    private String authorId;

    @Column(name = "user_registration_event_occurring_context")
    private String occurringContext;

    @Column(name = "user_registration_event_occurring_context_time")
    private LocalDateTime occurringContextTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_registration_event_type")
    private RegisterUserEventType eventType;

    @Column(name = "user_registration_event_version")
    private String eventVersion;

    @Column(name = "user_registration_event_entity_id")
    private String entityId;

    @Type(type = "jsonb")
    @Column(name = "user_registration_event_payload", columnDefinition = "jsonb")
    private RegisterUser payload;
}