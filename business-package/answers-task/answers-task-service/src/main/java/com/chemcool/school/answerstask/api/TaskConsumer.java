package com.chemcool.school.answerstask.api;

import com.chemcool.school.answerstask.tasks.chemfixedanswer.domain.ChemFixedAnswerTaskEvent;
import com.chemcool.school.answerstask.tasks.chemfixedanswer.service.ChemFixedAnswerTaskEventService;
import com.chemcool.school.answerstask.tasks.chemmatches.domain.ChemistryMatchingTaskEvent;
import com.chemcool.school.answerstask.tasks.chemmatches.service.ChemistryMatchingTaskEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@Service
@EnableKafka
@EnableTransactionManagement
@RequiredArgsConstructor
public class TaskConsumer {

    private final ChemFixedAnswerTaskEventService fixedAnswerTaskEventService;
    private final ChemistryMatchingTaskEventService matchingTaskEventService;

    @KafkaListener(topics = "fixed-answer-task")
    @KafkaHandler
    public void handleChemFixedAnswerTask(ConsumerRecord<String, ChemFixedAnswerTaskEvent> record) {
        ChemFixedAnswerTaskEvent event = record.value();
        log.info("Пойман журнал для логирования с ID: " + event.getEventId());
        fixedAnswerTaskEventService.handleEvent(event);
    }

    @KafkaListener(topics = "tasks-matching")
    @KafkaHandler
    public void handleChemSingleSelectTask(ConsumerRecord<String, ChemistryMatchingTaskEvent> record) {
        ChemistryMatchingTaskEvent event = record.value();
        log.info("Пойман журнал для логирования: " + event.getChemistryMatchingTaskEventId());
        matchingTaskEventService.handleEvent(event);
    }
}
