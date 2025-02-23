package com.desafiomagalu.communication_api.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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
    @Operation(description = "Endpoint responsável por agendar o envio da comunicação")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Comunicação agendada com sucesso.", content = @Content),
        @ApiResponse(responseCode = "422", description = "Os campos da comunicação não foram preenchidos corretamente.", content = @Content),
        @ApiResponse(responseCode = "400", description = "Erro de requisição.", content = @Content),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public ResponseEntity<String> scheduleCommunication(@RequestBody(required = true) @Valid CommunicationRequestDTO communicationRequestDTO) {
        CommunicationResponseDTO communicationResponseDTO = mapper.toResponse(communicationServicePort.scheduleCommunication(mapper.toDomain(communicationRequestDTO)));

        return ResponseEntity.status(HttpStatus.CREATED).body("Comunicação agendada com sucesso! ID de comunicação: " + communicationResponseDTO.id());
    }

    @GetMapping("/consultar")
    @Operation(description = "Endpoint responsável por consultar o envio da comunicação")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta efetuada com sucesso.", content = @Content),
        @ApiResponse(responseCode = "400", description = "Erro de requisição.", content = @Content),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public ResponseEntity<CommunicationResponseDTO> consultCommunication(@RequestParam(required = true, name = "id") Long id) {
        return ResponseEntity.ok().body(mapper.toResponse(communicationServicePort.consultCommunication(id)));
    }

    @PutMapping("/cancelar")
    @Operation(description = "Endpoint responsável por cancelar o envio da comunicação")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Comunicação cancelada com sucesso.", content = @Content),
        @ApiResponse(responseCode = "400", description = "Erro de requisição.", content = @Content),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor.", content = @Content)
    })
    public ResponseEntity<String> cancelCommunication(@RequestParam(required = true, name = "id") Long id) {
        communicationServicePort.cancelCommunication(id);

        return ResponseEntity.ok().body("Comunicação cancelada com sucesso!");
    }

}
