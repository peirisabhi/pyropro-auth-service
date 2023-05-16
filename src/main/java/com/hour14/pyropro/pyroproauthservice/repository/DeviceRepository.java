package com.hour14.pyropro.pyroproauthservice.repository;

import com.hour14.pyropro.pyroproauthservice.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 06/05/2023
 * Time: 10:09
 */
public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
