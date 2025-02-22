package com.desafiomagalu.communication_api.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafiomagalu.communication_api.adapters.in.dto.request.CommunicationRequestDTO;
import com.desafiomagalu.communication_api.adapters.in.dto.response.CommunicationResponseDTO;
import com.desafiomagalu.communication_api.adapters.in.mapper.ICommunicationControllerMapper;
import com.desafiomagalu.communication_api.ports.in.ICommunicationServicePort;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comunicacao")
public class CommunicationController {
    
    @Autowired
    private ICommunicationServicePort communicationServicePort;
    @Autowired
    private ICommunicationControllerMapper mapper;

    @PostMapping("/agendar")
    public ResponseEntity<String> scheduleCommunication(@RequestBody CommunicationRequestDTO communicationRequestDTO) {
        CommunicationResponseDTO communicationResponseDTO = mapper.toResponse(communicationServicePort.scheduleCommunication(mapper.toDomain(communicationRequestDTO)));

        return ResponseEntity.ok().body("Comunicação agendada com sucesso! ID de comunicação: " + communicationResponseDTO.id());
    }

    @GetMapping("/consultar")
    public ResponseEntity<CommunicationResponseDTO> consultCommunication(@RequestParam(required = true, name = "id") Long id) {
        return ResponseEntity.ok().body(mapper.toResponse(communicationServicePort.consultCommunication(id)));
    }

    @PutMapping("/cancelar")
    public ResponseEntity<String> cancelCommunication(@RequestParam(required = true, name = "id") Long id) {
        communicationServicePort.cancelCommunication(id);

        return ResponseEntity.ok().body("Comunicação cancelada com sucesso!");
    }

}
