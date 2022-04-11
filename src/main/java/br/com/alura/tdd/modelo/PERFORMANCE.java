package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum PERFORMANCE {
    TO_WISH {
        @Override
        public BigDecimal readjustmentPercentage() {
            return new BigDecimal("0.03");
        }
    },
    GOOD {
        @Override
        public BigDecimal readjustmentPercentage() {
            return new BigDecimal("0.15");
        }
    },
    EXCELLENT{
        @Override
        public BigDecimal readjustmentPercentage() {
            return new BigDecimal("0.2");
        }
    };

    public abstract BigDecimal readjustmentPercentage();
}
