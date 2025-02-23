package com.desafiomagalu.communication_api.adapters.out.mapper;

import org.mapstruct.Mapper;

import com.desafiomagalu.communication_api.application.domain.Communication;
import com.desafiomagalu.communication_api.infrastructure.entity.CommunicationEntity;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ICommunicationRepositoryMapper {
    
    CommunicationEntity toEntity(Communication communication);

    Communication toDomain(CommunicationEntity communicationEntity);
}
