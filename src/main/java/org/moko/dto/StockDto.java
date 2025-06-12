package org.moko.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.moko.entity.Stock;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class StockDto {
    private Long id;
    private String name;
    private BigDecimal currentPrice;
    private Long accumulatedVolume;
    private BigDecimal fluctuationRate;
    public StockDto(Stock stock){
        this.id = stock.getId();
        this.name = stock.getStockCode();
        this.currentPrice = stock.getClosePrice();
        this.accumulatedVolume = stock.getVolume();
        this.fluctuationRate = stock.getPriceRate();
    }
}
