package com.desafiomagalu.communication_api.adapters.in.dto.request;

import com.desafiomagalu.communication_api.application.domain.CommunicationType;

public record CommunicationRequestDTO (
    String recipient,
    String message,
    CommunicationType type
){}
