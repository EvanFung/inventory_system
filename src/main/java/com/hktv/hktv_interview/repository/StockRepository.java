package com.hktv.hktv_interview.repository;

import com.hktv.hktv_interview.model.Stock;
import com.hktv.hktv_interview.utils.IStockCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    List<Stock> findByProductIdAndWarehouseIdAndType(int productId, int warehouseId, String type);
    List<Stock> findByProductIdAndType(int productId, String type);
    List<Stock> findByWarehouse_codeAndProduct_code(String warehouse, String product);
    //find stock
    @Query(value="SELECT *, sum(qty) as total FROM stock GROUP BY warehouse_id, product_id",nativeQuery = true)
    List<Stock> findGroupStock();

    List<Stock> findByProductId(int productId);

    @Query(value="SELECT sum(qty) as total, product_id as pId, warehouse_id as wId, type as Status, name as warehouseName FROM stock INNER JOIN warehouse ON stock.warehouse_id=warehouse.id WHERE type=?1 AND product_id= ?2 GROUP BY warehouse_id, product_id",nativeQuery = true)
    List<IStockCount> findGroupStockByProductIdAndType(String type, int productId);
}
