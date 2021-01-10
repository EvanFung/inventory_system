package com.hktv.hktv_interview.service;

import com.hktv.hktv_interview.model.Stock;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface StockService {
    Stock addStock(Integer warehouseId, Integer productId, String operator, int qty, String type, Date createAt);

    List<Stock> getAllStock();

    List<Stock> getStockByProductId(Integer productId);

    void uploadStock(MultipartFile file);

}
