package com.hktv.hktv_interview.dto;


import com.hktv.hktv_interview.model.Dispatch;

import java.util.Date;

public class DispatchDto {
    private int id;
    private Integer destStockId;
    private Integer sourStockId;
    private Integer qty;

    private StockDto destStockDto;
    private StockDto sourStockDto;

    public DispatchDto() {
    }

    public DispatchDto(Dispatch dispatch) {
        this.id = dispatch.getId();
        this.destStockId = dispatch.getDestStockId();
        this.sourStockId = dispatch.getSourStockId();
        this.qty = dispatch.getQty();
        if (dispatch.getDestStock() != null) {
            this.destStockDto = new StockDto(dispatch.getDestStock());
        }
        if (dispatch.getSourStock() != null) {
            this.sourStockDto = new StockDto(dispatch.getSourStock());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDestStockId() {
        return destStockId;
    }

    public void setDestStockId(Integer destStockId) {
        this.destStockId = destStockId;
    }

    public Integer getSourStockId() {
        return sourStockId;
    }

    public void setSourStockId(Integer sourStockId) {
        this.sourStockId = sourStockId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public StockDto getDestStockDto() {
        return destStockDto;
    }

    public void setDestStockDto(StockDto destStockDto) {
        this.destStockDto = destStockDto;
    }

    public StockDto getSourStockDto() {
        return sourStockDto;
    }

    public void setSourStockDto(StockDto sourStockDto) {
        this.sourStockDto = sourStockDto;
    }
}
