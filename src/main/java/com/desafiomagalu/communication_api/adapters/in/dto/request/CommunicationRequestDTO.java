package com.desafiomagalu.communication_api.adapters.in.dto.request;

import com.desafiomagalu.communication_api.application.domain.CommunicationType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommunicationRequestDTO (
    @NotBlank(message = "O destinatário da comunicação é obrigatório!")
    String recipient,

    @NotBlank(message = "Mensagem da comunicação obrigatória!")
    String message,

    @NotNull(message = "O tipo de comunicação é obrigatório!")
    CommunicationType type
){}
