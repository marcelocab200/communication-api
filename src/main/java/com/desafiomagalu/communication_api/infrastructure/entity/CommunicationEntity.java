package com.desafiomagalu.communication_api.infrastructure.entity;


import java.time.LocalDateTime;
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

    @Column(name = "date_hour")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHour;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "message")
    private String message;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CommunicationType type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CommunicationStatus status;
}
