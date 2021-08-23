package com.chemcool.school.tasks.service.chemfixedanswer;


import com.chemcool.school.tasks.domain.chemfixedanswer.ChemFixedAnswerTaskEvent;
import com.chemcool.school.tasks.infrastructure.storage.chemfixedanswer.ChemFixedAnswerTaskEventJournal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChemFixedAnswerTaskEventService {

    private final ChemFixedAnswerTaskEventJournal eventJournal;

    public void handleEvent(ChemFixedAnswerTaskEvent event) {
        eventJournal.save(event);
        log.info("Событие отправлено на сохранение");
    }
}
