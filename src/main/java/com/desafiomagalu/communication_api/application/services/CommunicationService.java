package com.desafiomagalu.communication_api.application.services;

import org.springframework.stereotype.Service;

import com.desafiomagalu.communication_api.application.domain.Communication;
import com.desafiomagalu.communication_api.application.domain.CommunicationStatus;
import com.desafiomagalu.communication_api.ports.in.ICommunicationServicePort;
import com.desafiomagalu.communication_api.ports.out.ICommunicationRepositoryPort;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CommunicationService implements ICommunicationServicePort {

    private ICommunicationRepositoryPort repository;

    @Override
    public Communication scheduleCommunication(Communication communication) {      
        communication.setDateHour(java.time.LocalDateTime.now()); 
        communication.setStatus(CommunicationStatus.SCHEDULED);
        return repository.saveCommunication(communication);
    }

    @Override
    public Communication consultCommunication(Long id) {
        return repository.getCommunication(id)
            .orElseThrow(() -> new IllegalStateException("Comunicação não foi encontrada."));
    }
    
    @Override
    @Transactional
    public Communication cancelCommunication(Long id) {
        final Communication consultedCommunication = consultCommunication(id);

        if (consultedCommunication.getStatus() == CommunicationStatus.CANCELED) {
            throw new IllegalStateException("A comunicação já foi cancelada.");
        }

        return repository.updateCommunication(id, CommunicationStatus.CANCELED)
            .orElseThrow(() -> new IllegalStateException("Ocorreu um erro ao cancelar a comunicação."));
    }
}
