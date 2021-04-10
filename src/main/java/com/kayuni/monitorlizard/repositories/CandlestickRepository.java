package com.kayuni.monitorlizard.repositories;

import java.util.List;

import com.kayuni.monitorlizard.models.CandlestickEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandlestickRepository extends JpaRepository<CandlestickEntity, Long> {
    List<CandlestickEntity> findByOpenTime(Long openTime);
    CandlestickEntity findTopByOrderByOpenTimeDesc();
}
