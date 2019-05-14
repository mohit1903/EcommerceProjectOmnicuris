package com.mohit.ecommerce.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.ecommerce.entity.Inventory;
import com.mohit.ecommerce.repository.InventoryRepository;
import com.mohit.ecommerce.service.InventoryService;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/inventory")
@Transactional
public class InventoryController extends InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@GetMapping
	public Iterable<Inventory> findAll() {
		return inventoryRepository.findAll();
	}

	@GetMapping(path = "/{Id}")
	public Inventory find(@PathVariable("Id") String id) {
		return inventoryRepository.getOne(id);
	}

	@PostMapping(consumes = "application/json")
	public Inventory create(@RequestBody Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	@DeleteMapping(path = "/{Id}")
	public void delete(@PathVariable("Id") String id) {
		inventoryRepository.deleteById(id);
	}

	@PutMapping(path = "/{Id}")
	public Inventory update(@PathVariable("Id") String id, @RequestBody Inventory inventory) throws BadHttpRequest {
		if (inventoryRepository.existsById(id)) {
			return inventoryRepository.save(inventory);
		} else {
			throw new BadHttpRequest();
		}
	}

	@GetMapping(path = "/findall")
	public List findall() {
		return findAllItem();
	}

}
