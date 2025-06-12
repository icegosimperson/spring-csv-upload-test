package org.moko.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stocks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stocks {
    @Id
    @Column(name="stock_code", length = 10)
    private String stockCode;

    @Column(name = "stock_name")
    private String stockName;

    @Column(name="market_type")
    private String marketType;

    @Column(name="logo_url", columnDefinition = "LONGTEXT")
    private String logoUrl;
}
