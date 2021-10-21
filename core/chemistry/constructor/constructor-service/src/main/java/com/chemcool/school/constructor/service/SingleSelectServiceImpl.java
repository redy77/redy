package com.chemcool.school.constructor.service;

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.constructor.domain.SingleSelectTask;
import com.chemcool.school.constructor.infrastructure.storage.SingleSelectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SingleSelectServiceImpl implements SingleSelectService {

    private final SingleSelectRepository repository;

    @Override
    public String save(SingleSelectRepresentation representation) {
        SingleSelectTask task = SingleSelectRepresentation.buildTask(representation);
        repository.save(task);
        return task.getTaskId();
    }
}
