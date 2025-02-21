package com.desafiomagalu.communication_api.ports.out;

import com.desafiomagalu.communication_api.application.domain.Communication;

public interface ICommunicationRepositoryPort {
    
    public Communication saveCommunication(Communication communication);

    public Communication changeCommunicationStatus(Communication communication);

    public Communication getCommunication(Communication communication);
}
