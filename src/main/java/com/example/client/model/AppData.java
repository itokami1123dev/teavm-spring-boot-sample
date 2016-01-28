package com.example.client.model;

import java.math.BigDecimal;

public class AppData {

    /**
     * base 底となる数
     */
    private BigDecimal base;

    /**
     * exponent (base を累乗する指数。)
     */
    private BigDecimal exponent;

    public AppData(String base, String exponent) {
        this.base = new BigDecimal(base);
        this.exponent = new BigDecimal(exponent);
    }

    public BigDecimal getBase() {
        return base;
    }

    public void setBase(BigDecimal base) {
        this.base = base;
    }

    public BigDecimal getExponent() {
        return exponent;
    }

    public void setExponent(BigDecimal exponent) {
        this.exponent = exponent;
    }

    public BigDecimal compute() {
        return base.pow(exponent.intValue());
    }
}

