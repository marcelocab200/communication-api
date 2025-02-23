package com.desafiomagalu.communication_api.application.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiomagalu.communication_api.application.domain.Communication;
import com.desafiomagalu.communication_api.application.domain.CommunicationStatus;
import com.desafiomagalu.communication_api.ports.in.ICommunicationServicePort;
import com.desafiomagalu.communication_api.ports.out.ICommunicationRepositoryPort;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class CommunicationService implements ICommunicationServicePort {

    @Autowired
    private ICommunicationRepositoryPort repository;

    @Override
    @Transactional
    public Communication scheduleCommunication(Communication communication) {     

        log.info("Agendando comunicação...");

        Date localDateTime2Date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()); 

        communication.setDateHour(localDateTime2Date); 
        communication.setStatus(CommunicationStatus.SCHEDULED);

        Communication scheduleResult = repository.saveCommunication(communication);

        log.info("Comunicação agendada com sucesso.");

        return scheduleResult;
    }

    @Override
    @Transactional
    public Communication consultCommunication(Long id) {

        log.info("Consultando comunicação...");

        Communication consultResult = repository.getCommunication(id)
        .orElseThrow(() -> new IllegalStateException("Comunicação não foi encontrada."));

        log.info("Consulta efetuada com sucesso.");

        return consultResult;
    }
    
    @Override
    @Transactional
    public Communication cancelCommunication(Long id) {

        log.info("Cancelando comunicação...");

        Communication consultedCommunication = consultCommunication(id);

        if (consultedCommunication.getStatus() == CommunicationStatus.CANCELED) {
            log.error("Não foi possível cancelar a comunicação.");
            throw new IllegalStateException("A comunicação já foi cancelada.");
        }

        Communication cancelResult = repository.updateCommunication(id, CommunicationStatus.CANCELED)
            .orElseThrow(() -> new IllegalStateException("Ocorreu um erro ao cancelar a comunicação."));

        log.info("Comunicação cancelada com sucesso.");

        return cancelResult;
    }
}
