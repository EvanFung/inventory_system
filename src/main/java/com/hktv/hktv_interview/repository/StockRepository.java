package com.hktv.hktv_interview.repository;

import com.hktv.hktv_interview.model.Stock;
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
}
