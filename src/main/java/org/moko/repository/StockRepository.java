package org.moko.repository;

import org.moko.entity.StockDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StockDetail, Long> {
    List<StockDetail> findByStockCode(String stockCode);
}
