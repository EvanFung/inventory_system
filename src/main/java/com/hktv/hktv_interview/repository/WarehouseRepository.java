package com.hktv.hktv_interview.repository;

import com.hktv.hktv_interview.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository  extends JpaRepository<Warehouse, Integer> {
}
