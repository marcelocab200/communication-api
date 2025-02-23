package com.desafiomagalu.communication_api.adapters.in.dto.response;

import java.sql.Date;

import com.desafiomagalu.communication_api.application.domain.CommunicationStatus;
import com.desafiomagalu.communication_api.application.domain.CommunicationType;

public record CommunicationResponseDTO (
    Long id,
    Date dateHour,
    String recipient,
    String message,
    CommunicationType type,
    CommunicationStatus status
){}
