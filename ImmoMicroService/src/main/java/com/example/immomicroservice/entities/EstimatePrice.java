package com.example.immomicroservice.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstimatePrice {
        private String maxPrice;
        private String minPrice;
        private String averagePrice;

        public EstimatePrice(String maxPrice, String minPrice, String averagePrice) {
            this.maxPrice = maxPrice;
            this.minPrice = minPrice;
            this.averagePrice = averagePrice;
        }


}
