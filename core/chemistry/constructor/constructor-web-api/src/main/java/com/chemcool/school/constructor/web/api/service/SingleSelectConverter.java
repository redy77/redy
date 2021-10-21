package com.chemcool.school.constructor.web.api.service;

import com.chemcool.school.constructor.domain.representation.SingleSelectRepresentation;
import com.chemcool.school.constructor.web.api.dto.SingleSelectDto;

public interface SingleSelectConverter {
    SingleSelectRepresentation build(SingleSelectDto dto);
}
