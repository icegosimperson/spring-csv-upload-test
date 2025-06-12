package org.moko.controller;

import lombok.RequiredArgsConstructor;
import org.moko.dto.StockDetailDto;
import org.moko.entity.StockDetail;
import org.moko.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    private StockRepository stockRepository;
    @GetMapping
    public List<StockDetailDto> getAllStocks(){
        return stockRepository.findAll().stream()
                .map(StockDetailDto::new)  // ✅ DTO 생성자 사용
                .collect(Collectors.toList());
    }

    @GetMapping("/{code}")
    public List<StockDetail> getStocksByCode(@PathVariable String code){
        return stockRepository.findByStockCode(code);
    }
    @GetMapping("/market")
    public List<StockDetailDto> getMarketStockList() {
        return stockRepository.findAll().stream()
                .map(StockDetailDto::new)
                .collect(Collectors.toList());
    }
}
