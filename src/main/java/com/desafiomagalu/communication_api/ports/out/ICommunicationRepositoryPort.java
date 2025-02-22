package com.desafiomagalu.communication_api.ports.out;

import java.util.Optional;

import com.desafiomagalu.communication_api.application.domain.Communication;
import com.desafiomagalu.communication_api.application.domain.CommunicationStatus;

public interface ICommunicationRepositoryPort {
    
    public Communication saveCommunication(Communication communication);

    public Optional<Communication> updateCommunication(Long id, CommunicationStatus status);

    public Optional<Communication> getCommunication(Long id);
}
