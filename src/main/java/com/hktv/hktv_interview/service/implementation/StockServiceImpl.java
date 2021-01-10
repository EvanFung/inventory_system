package com.hktv.hktv_interview.service.implementation;

import com.hktv.hktv_interview.model.Dispatch;
import com.hktv.hktv_interview.model.Inventory;
import com.hktv.hktv_interview.model.Product;
import com.hktv.hktv_interview.model.Stock;
import com.hktv.hktv_interview.repository.InventoryRepository;
import com.hktv.hktv_interview.repository.StockRepository;
import com.hktv.hktv_interview.service.StockService;
import com.hktv.hktv_interview.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public Stock addStock(Integer warehouseId, Integer productId, String operator, int qty, String type, Date createAt) {
        List<Stock> stocks = stockRepository.findByProductIdAndWarehouseIdAndType(productId, warehouseId, type);
        Optional<Inventory> inventory = inventoryRepository.findByProductIdAndWarehouseId(productId, warehouseId);
        Stock stock = new Stock();
        //建立入货表
        stock.setWarehouseId(warehouseId);
        stock.setProductId(productId);
        stock.setOperator(operator);
        stock.setQty(qty);
        stock.setType(type);
        stock.setCreateAt(createAt);
        stock.setSourDispatch(new HashSet<>());
        stock.setDestDispatch(new HashSet<>());
        stock = stockRepository.save(stock);
        System.out.println(type);
        if (type.equals("IN_STOCK")) {
            if (!inventory.isPresent()) {
                //建立存货表
                Inventory store = new Inventory();
                store.setProductId(productId);
                store.setWarehouseId(warehouseId);
                store.setQty(qty);
                store.setCreateAt(createAt);
                inventoryRepository.save(store);
            } else {
                //如果存货表存在，更新相关的存货资料
                System.out.println(stocks.toArray().length);
                //统计入货单记录
                int sum = stocks.stream().map(x -> x.getQty()).reduce(0, Integer::sum);
                System.out.println(sum);
                //更新存货表
                Inventory i = inventory.get();
                i.setQty(sum + qty);
                inventoryRepository.save(i);
            }
        }
        return stock;
    }

    @Override
    public List<Stock> getAllStock() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream().collect(Collectors.toList());
    }

    @Override
    public List<Stock> getStockByProductId(Integer productId) {
        List<Stock> stocks = stockRepository.findByProductId(productId);
        return stocks.stream().collect(Collectors.toList());
    }

    @Override
    public void uploadStock(MultipartFile file) {
        try {
            List<Stock> stocks = CSVHelper.csvToStock(file.getInputStream());
            stockRepository.saveAll(stocks);
            //update inventory as well
            List<Stock> groupedStock = stockRepository.findGroupStock();
            groupedStock.forEach(stock -> {
                int warehouseId = stock.getWarehouseId();
                int productId = stock.getProductId();
                Optional<Inventory> inventory = inventoryRepository.findByProductIdAndWarehouseId(productId, warehouseId);
                if(inventory.isPresent()) {
                  Inventory i =   inventory.get();
                  i.setQty(i.getQty() + stock.getQty());
                  inventoryRepository.save(i);
                }
            });
        }catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }


}
