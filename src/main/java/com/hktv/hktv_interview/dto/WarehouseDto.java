package com.hktv.hktv_interview.dto;


import com.hktv.hktv_interview.model.Warehouse;

public class WarehouseDto {
    private int id;
    private String code;
    private String name;

    public WarehouseDto() {
    }

    public WarehouseDto(Warehouse warehouse) {
        this.id = warehouse.getId();
        this.code = warehouse.getCode();
        this.name = warehouse.getName();
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
}
