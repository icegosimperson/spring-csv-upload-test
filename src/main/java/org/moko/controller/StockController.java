package org.moko.controller;

import lombok.RequiredArgsConstructor;
import org.moko.dto.StockDto;
import org.moko.entity.Stock;
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
    public List<Stock> getAllStocks(){
        return stockRepository.findAll();
    }

    @GetMapping("/{code}")
    public List<Stock> getStocksByCode(@PathVariable String code){
        return stockRepository.findByStockCode(code);
    }
    @GetMapping("/market")
    public List<StockDto> getMarketStockList() {
        return stockRepository.findAll().stream()
                .map(StockDto::new)
                .collect(Collectors.toList());
    }
}
