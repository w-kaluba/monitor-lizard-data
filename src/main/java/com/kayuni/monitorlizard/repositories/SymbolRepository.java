package com.kayuni.monitorlizard.repositories;

import java.util.List;

import com.kayuni.monitorlizard.models.SymbolEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SymbolRepository extends JpaRepository<SymbolEntity, String> {
    List<SymbolEntity> findByName(String name);
    SymbolEntity findTopByOrderByChangeDesc();
}