package com.hktv.hktv_interview.repository;

import com.hktv.hktv_interview.model.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispatchRepository extends JpaRepository<Dispatch, Integer> {
}
