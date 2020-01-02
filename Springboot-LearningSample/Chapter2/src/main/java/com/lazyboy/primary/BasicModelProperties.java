package com.lazyboy.primary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BasicModelProperties {

    @Value("${com.lazyboy.name}")
    private String name;
    @Value("${com.lazyboy.title}")
    private String title;
    @Value("${com.lazyboy.value}")
    private String value;
    @Value("${com.lazyboy.number}")
    private int number;
    @Value("${com.lazyboy.bignumber}")
    private long bignumber;
    @Value("${com.lazyboy.uuid}")
    private String uuid;
    @Value("${com.lazyboy.maxTen}")
    private int maxTen;
    @Value("${com.lazyboy.min2max}")
    private int min2max;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getBignumber() {
        return bignumber;
    }

    public void setBignumber(long bignumber) {
        this.bignumber = bignumber;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getMaxTen() {
        return maxTen;
    }

    public void setMaxTen(int maxTen) {
        this.maxTen = maxTen;
    }

    public int getMin2max() {
        return min2max;
    }

    public void setMin2max(int min2max) {
        this.min2max = min2max;
    }
}
