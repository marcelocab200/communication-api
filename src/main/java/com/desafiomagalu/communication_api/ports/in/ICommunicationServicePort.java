package com.desafiomagalu.communication_api.ports.in;

import com.desafiomagalu.communication_api.application.domain.Communication;

public interface ICommunicationServicePort {
    
    public Communication scheduleCommunication(Communication communication);

    public Communication consultCommunication(Communication communication);

    public Communication cancelCommunication(Communication communication);
}
