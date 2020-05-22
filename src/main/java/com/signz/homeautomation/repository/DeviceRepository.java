package com.signz.homeautomation.repository;

import com.signz.homeautomation.model.Device;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends PagingAndSortingRepository<Device, Integer> {
}
