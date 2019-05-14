package com.mohit.ecommerce.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.ecommerce.entity.Inventory;
import com.mohit.ecommerce.repository.InventoryRepository;

@Service("inventoryService")
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Autowired
	EntityManager entityManager;

	public List findAllItem() {
		Query query = entityManager.createNativeQuery("SELECT item FROM Inventory ");
		return query.getResultList();
	}

}
