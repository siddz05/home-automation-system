package com.signz.homeautomation.repository;

import com.signz.homeautomation.model.Device;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends PagingAndSortingRepository<Device, Integer> {

    @Query("select d from Device d join d.commandSet c where d.id = :deviceId and c.id = :commandId")
    Device findByDeviceIdAndCommandId(@Param("deviceId") Integer deviceId, @Param("commandId") Integer commandId);
}
