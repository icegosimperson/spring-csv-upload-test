package org.moko.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "stock_detail")
public class StockDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_code", nullable = false, insertable = false, updatable = false)
    private String stockCode;

    @Column(name = "open_price")
    private BigDecimal openPrice;

    @Column(name = "high_price")
    private BigDecimal highPrice;

    @Column(name = "low_price")
    private BigDecimal lowPrice;

    @Column(name = "close_price")
    private BigDecimal closePrice;

    @Column(name = "prev_close_price")
    private BigDecimal prevClosePrice;

    @Column(name = "price_diff")
    private BigDecimal priceDiff;

    @Column(name = "price_rate")
    private BigDecimal priceRate;

    @Column(name = "price_sign")
    private Byte priceSign;

    @Column(name = "volume")
    private Long volume;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stock_code", referencedColumnName = "stock_code")
    private Stocks stocks;
}
