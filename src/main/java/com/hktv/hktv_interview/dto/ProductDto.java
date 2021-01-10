package com.hktv.hktv_interview.dto;

import com.hktv.hktv_interview.model.Product;

import java.util.Date;

public class ProductDto {
    private int id;
    private String code;
    private String name;
    private int weight;
    private String type;
    private String unit;
    private Date createAt;
    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.code = product.getCode();
        this.name = product.getName();
        this.weight = product.getWeight();
        this.type = product.getType();
        this.unit = product.getUnit();
        this.createAt = product.getCreateAt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
