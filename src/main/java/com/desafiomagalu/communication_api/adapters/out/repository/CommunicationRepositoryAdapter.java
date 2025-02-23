package com.desafiomagalu.communication_api.adapters.out.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.desafiomagalu.communication_api.adapters.out.mapper.ICommunicationRepositoryMapper;
import com.desafiomagalu.communication_api.application.domain.Communication;
import com.desafiomagalu.communication_api.application.domain.CommunicationStatus;
import com.desafiomagalu.communication_api.infrastructure.repository.ICommunicationJpaRepository;
import com.desafiomagalu.communication_api.ports.out.ICommunicationRepositoryPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CommunicationRepositoryAdapter implements ICommunicationRepositoryPort {

    @Autowired
    private ICommunicationJpaRepository repository;
    @Autowired
    private ICommunicationRepositoryMapper mapper;

    @Override
    public Communication saveCommunication(Communication communication) {

        log.info("Salvando comunicação no banco de dados...");

        Communication saveResult = mapper.toDomain(repository.save(mapper.toEntity(communication)));

        log.info("Comunicação salva com sucesso.");

        return saveResult;
    }

    @Override
    public Optional<Communication> updateCommunication(Long id, CommunicationStatus status) {

        log.info("Fazendo a alteração no banco de dados...");

        repository.updateById(id, status);

        log.info("Status alterado com sucesso.");

        return getCommunication(id);
    }

    public Optional<Communication> getCommunication(Long id) {

        log.info("Buscando comunicação no banco de dados...");

        Optional<Communication> getResult = repository.findById(id).map(mapper::toDomain);

        log.info("Comunicação encontrada com sucesso.");

        return getResult;
    }
    
}
