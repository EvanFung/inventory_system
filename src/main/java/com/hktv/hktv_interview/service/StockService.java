package com.hktv.hktv_interview.service;

import com.hktv.hktv_interview.model.Stock;

import java.util.Date;
import java.util.List;

public interface StockService {
    Stock addStock(Integer warehouseId, Integer productId, String operator, int qty, String type, Date createAt);

    List<Stock> getAllStock();
}
