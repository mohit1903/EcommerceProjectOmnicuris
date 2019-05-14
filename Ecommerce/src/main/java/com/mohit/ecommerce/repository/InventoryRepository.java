package com.mohit.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.mohit.ecommerce.entity.Inventory;

@RestResource(exported = false)
public interface InventoryRepository extends JpaRepository<Inventory, String> {

}
