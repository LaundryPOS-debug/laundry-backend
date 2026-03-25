package com.laundry.system.repository;

import com.laundry.system.entity.AddonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddonRepository extends JpaRepository<AddonEntity, Long> {
}