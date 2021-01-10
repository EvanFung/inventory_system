package com.hktv.hktv_interview.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Stock {
    private int id;
    private Integer warehouseId;
    private Integer productId;
    private String operator;
    private int qty;
    //in stock or out stock?
    private String type;
    private Date createAt;

    private Product product;
    private Warehouse warehouse;

    private Set<Dispatch> destDispatch;
    private Set<Dispatch> sourDispatch;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "qty")
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "warehouse_id")
    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Basic
    @Column(name = "product_id")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "create_at")
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product getProductByProductId) {
        this.product = getProductByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse getWarehouseByWarehouseId) {
        this.warehouse = getWarehouseByWarehouseId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "destStock", cascade = CascadeType.ALL)
    public Set<Dispatch> getDestDispatch() {
        return destDispatch;
    }

    public void setDestDispatch(Set<Dispatch> destDispatch) {
        this.destDispatch = destDispatch;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sourStock", cascade = CascadeType.ALL)
    public Set<Dispatch> getSourDispatch() {
        return sourDispatch;
    }

    public void setSourDispatch(Set<Dispatch> sourDispatch) {
        this.sourDispatch = sourDispatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return warehouseId.equals(stock.warehouseId) && productId.equals(stock.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warehouseId, productId);
    }
}
