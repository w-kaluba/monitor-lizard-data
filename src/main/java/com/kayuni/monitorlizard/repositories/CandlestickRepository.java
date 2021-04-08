package com.kayuni.monitorlizard.repositories;

import java.util.List;

import com.kayuni.monitorlizard.models.Candlestick;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandlestickRepository extends JpaRepository<Candlestick, Long> {
    List<Candlestick> findByOpenTime(Long openTime);
}
