package com.desafiomagalu.communication_api.adapters.out.mapper;

import org.mapstruct.Mapper;

import com.desafiomagalu.communication_api.application.domain.Communication;
import com.desafiomagalu.communication_api.infrastructure.entity.CommunicationEntity;

@Mapper(componentModel = "spring")
public interface CommunicationMapper {
    
    CommunicationEntity toEntity(Communication communication);

    Communication toDomain(CommunicationEntity communicationEntity);
}
