package com.desafiomagalu.communication_api.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.desafiomagalu.communication_api.application.domain.CommunicationStatus;
import com.desafiomagalu.communication_api.infrastructure.entity.CommunicationEntity;

public interface ICommunicationJpaRepository extends JpaRepository<CommunicationEntity, Long> {

    @Modifying
    @Query(value = "UPDATE CommunicationEntity c SET c.status = :status WHERE c.id = :id")
    Integer updateById(@Param("id") Long id, @Param("status") CommunicationStatus status);
}