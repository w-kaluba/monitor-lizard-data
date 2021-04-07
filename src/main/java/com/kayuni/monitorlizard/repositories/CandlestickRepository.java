package com.kayuni.monitorlizard.repositories;

import com.kayuni.monitorlizard.models.Candlestick;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kayuni.monitorlizard.models.Candlestick;
import java.util.List;
import java.sql.Date;

public interface CandlestickRepository extends JpaRepository<Candlestick, Long> {
    List<Candlestick> findByTimestamp(Date timestamp);
}
