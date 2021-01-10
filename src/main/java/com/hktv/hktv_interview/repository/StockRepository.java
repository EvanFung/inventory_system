package com.hktv.hktv_interview.repository;

import com.hktv.hktv_interview.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    //    List<CartProduct> findByShoppingCartIdAndProductId(int shoppingCartId, int productId);
    List<Stock> findByProductIdAndWarehouseIdAndType(int productId, int warehouseId, String type);
    List<Stock> findByProductIdAndType(int productId, String type);
    List<Stock> findByWarehouse_codeAndProduct_code(String warehouse, String product);
}
