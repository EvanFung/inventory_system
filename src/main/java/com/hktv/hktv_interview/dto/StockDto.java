package com.hktv.hktv_interview.dto;

import com.hktv.hktv_interview.model.Stock;

import java.util.Date;

public class StockDto {
    private int id;
    private WarehouseDto warehouse;
    private ProductDto product;
    private String operator;
    private int qty;
    //in stock or out stock?
    private String type;
    private Date createAt;

    public StockDto() {

    }


    public StockDto(Stock stock) {
        this.id = stock.getId();
        this.operator = stock.getOperator();
        this.qty = stock.getQty();
        this.type = stock.getType();
        this.operator = stock.getOperator();
        if (stock.getWarehouse() != null) {
            this.warehouse = new WarehouseDto(stock.getWarehouse());
        }
        if (stock.getProduct() != null) {
            this.product = new ProductDto(stock.getProduct());
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WarehouseDto getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseDto warehouse) {
        this.warehouse = warehouse;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
