package com.desafiomagalu.communication_api.adapters.out.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.desafiomagalu.communication_api.adapters.out.mapper.CommunicationMapper;
import com.desafiomagalu.communication_api.application.domain.Communication;
import com.desafiomagalu.communication_api.infrastructure.repository.ICommunicationJpaRepository;
import com.desafiomagalu.communication_api.ports.out.ICommunicationRepositoryPort;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CommunicationRepositoryAdapter implements ICommunicationRepositoryPort {

    private ICommunicationJpaRepository repository;
    private CommunicationMapper mapper;

    @Override
    public Communication saveCommunication(Communication communication) {
        return mapper.toDomain(repository.save(mapper.toEntity(communication)));
    }

    @Override
    public Communication updateCommunication(Long id) {
        return mapper.toDomain(repository.updateById(id));
    }

    public Optional<Communication> getCommunication(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }
    
}
