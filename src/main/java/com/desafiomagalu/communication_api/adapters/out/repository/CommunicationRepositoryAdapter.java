package com.desafiomagalu.communication_api.adapters.out.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.desafiomagalu.communication_api.adapters.out.mapper.ICommunicationRepositoryMapper;
import com.desafiomagalu.communication_api.application.domain.Communication;
import com.desafiomagalu.communication_api.application.domain.CommunicationStatus;
import com.desafiomagalu.communication_api.infrastructure.repository.ICommunicationJpaRepository;
import com.desafiomagalu.communication_api.ports.out.ICommunicationRepositoryPort;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CommunicationRepositoryAdapter implements ICommunicationRepositoryPort {

    @Autowired
    private ICommunicationJpaRepository repository;
    @Autowired
    private ICommunicationRepositoryMapper mapper;

    @Override
    public Communication saveCommunication(Communication communication) {
        return mapper.toDomain(repository.save(mapper.toEntity(communication)));
    }

    @Override
    public Optional<Communication> updateCommunication(Long id, CommunicationStatus status) {
        repository.updateById(id, status);

        return getCommunication(id);
    }

    public Optional<Communication> getCommunication(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }
    
}
