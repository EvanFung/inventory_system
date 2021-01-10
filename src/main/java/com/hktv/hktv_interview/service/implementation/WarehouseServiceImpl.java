package com.hktv.hktv_interview.service.implementation;

import com.hktv.hktv_interview.model.Warehouse;
import com.hktv.hktv_interview.repository.WarehouseRepository;
import com.hktv.hktv_interview.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Override
    public Warehouse addWarehouse(String code, String name) {
        Warehouse warehouse = new Warehouse();
        warehouse.setCode(code);
        warehouse.setName(name);
        warehouseRepository.save(warehouse);
        return warehouse;
    }
}
