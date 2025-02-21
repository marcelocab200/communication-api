package com.desafiomagalu.communication_api.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafiomagalu.communication_api.infrastructure.entity.CommunicationEntity;

public interface ICommunicationJpaRepository extends JpaRepository<CommunicationEntity, Long> {

    public CommunicationEntity updateById(Long id);
}