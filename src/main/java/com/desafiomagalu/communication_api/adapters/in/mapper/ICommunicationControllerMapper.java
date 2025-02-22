package com.desafiomagalu.communication_api.adapters.in.mapper;

import org.mapstruct.Mapper;

import com.desafiomagalu.communication_api.adapters.in.dto.request.CommunicationRequestDTO;
import com.desafiomagalu.communication_api.adapters.in.dto.response.CommunicationResponseDTO;
import com.desafiomagalu.communication_api.application.domain.Communication;

@Mapper(componentModel = "spring")
public interface ICommunicationControllerMapper {
    
    Communication toDomain(CommunicationRequestDTO communicationRequestDTO);

    CommunicationResponseDTO toResponse (Communication communication);
}
