package com.chemcool.school.lesson.api.event;
import com.chemcool.school.lesson.domain.singleselect.ChemSingleSelectTaskEvent;
import com.chemcool.school.lesson.service.singleselect.ChemSingleSelectTaskEventService;
import com.chemcool.school.lesson.service.singleselect.ChemSingleSelectTaskService;
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
public class ChemSingleSelectTaskConsumer {

    private final ChemSingleSelectTaskEventService eventService;
    private final ChemSingleSelectTaskService taskService;

    @KafkaListener(topics = "SINGLE_SELECT", containerFactory = "chemSingleSelectKafkaListenerContainerFactory")
    @KafkaHandler
    public void handleChemSingleSelectTask(ConsumerRecord<String, ChemSingleSelectTaskEvent> record) {
        ChemSingleSelectTaskEvent event = record.value();
        log.info("Пойман журнал для логирования: " + event.getTaskEventId());
        eventService.handleEvent(event);
        taskService.save(event.getPayload());
    }

}
