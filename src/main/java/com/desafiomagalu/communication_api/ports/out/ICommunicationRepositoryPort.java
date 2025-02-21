package com.desafiomagalu.communication_api.ports.out;

import java.util.Optional;

import com.desafiomagalu.communication_api.application.domain.Communication;

public interface ICommunicationRepositoryPort {
    
    public Communication saveCommunication(Communication communication);

    public Communication updateCommunication(Long id);

    public Optional<Communication> getCommunication(Long id);
}
