package com.hktv.hktv_interview.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Dispatch {
    private int id;
    private Integer destStockId;
    private Integer sourStockId;
    private Stock destStock;
    private Stock sourStock;
    private Integer qty;
    private Date createAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "dest_stock_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Stock getDestStock() {
        return destStock;
    }

    public void setDestStock(Stock getDestStockByStockId) {
        this.destStock = getDestStockByStockId;
    }

    @ManyToOne
    @JoinColumn(name = "sour_stock_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Stock getSourStock() {
        return sourStock;
    }

    public void setSourStock(Stock getSourStockByStockId) {
        this.sourStock = getSourStockByStockId;
    }

    @Basic
    @Column(name = "qty")
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "dest_stock_id")
    public Integer getDestStockId() {
        return destStockId;
    }

    public void setDestStockId(Integer destStockId) {
        this.destStockId = destStockId;
    }
    @Basic
    @Column(name = "sour_stock_id")
    public Integer getSourStockId() {
        return sourStockId;
    }

    public void setSourStockId(Integer sourStockId) {
        this.sourStockId = sourStockId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
