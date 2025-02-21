package com.desafiomagalu.communication_api.infrastructure.entity;


import java.util.Date;

import com.desafiomagalu.communication_api.application.domain.CommunicationStatus;
import com.desafiomagalu.communication_api.application.domain.CommunicationType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "communication")
public class CommunicationEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateHour;
    private String recipient;
    private String message;

    @Enumerated(EnumType.STRING)
    private CommunicationType type;

    @Enumerated(EnumType.STRING)
    private CommunicationStatus status;
}
