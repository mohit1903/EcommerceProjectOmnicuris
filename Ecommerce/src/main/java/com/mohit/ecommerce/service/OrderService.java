package com.mohit.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.ecommerce.entity.Orders;
import com.mohit.ecommerce.repository.OrderRepository;

@Service("orderService")
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	EntityManager entityManager;

	public synchronized boolean OneOrder(Orders order) {
		Query query = entityManager.createNativeQuery(
				"SELECT count as Count FROM Inventory as inv WHERE inv.id = '" + order.getId() + "'");
		boolean result = false;
		int diff = 0;
		if (query.getResultList().size() > 0) {
			if (Integer.parseInt(query.getResultList().get(0).toString()) >= order.getCount()) {
				orderRepository.save(order);
				diff = Integer.parseInt(query.getResultList().get(0).toString()) - order.getCount();
				Query query2 = entityManager.createNativeQuery(
						"UPDATE Inventory SET count =" + diff + " WHERE id  = '" + order.getId() + "'");
				query2.executeUpdate();
				result = true;
			}
		}

		return result;
	}

	public synchronized List<String> BulkOrders(List<Orders> orders) {
		List<String> result = new ArrayList<>();
		int size = orders.size(), iterator = 0;
		while (size-- > 0) {
			Query query = entityManager.createNativeQuery("SELECT count as Count FROM Inventory as inv WHERE inv.id = '"
					+ orders.get(iterator).getId() + "'");
			int diff = 0;
			if (query.getResultList().size() > 0) {
				if (Integer.parseInt(query.getResultList().get(0).toString()) >= orders.get(iterator).getCount()) {
					orderRepository.save(orders.get(iterator));
					diff = Integer.parseInt(query.getResultList().get(0).toString()) - orders.get(iterator).getCount();
					Query query2 = entityManager.createNativeQuery("UPDATE Inventory SET count =" + diff
							+ " WHERE id  = '" + orders.get(iterator).getId() + "'");
					query2.executeUpdate();
					result.add("order no " + orders.get(0).getId() + "is placed Successfully");
				} else
					result.add("order no " + orders.get(0).getId()
							+ "is UnSuccessfully as Quantitiy not Availaible , Availaible Quantity for this order is "
							+ orders.get(iterator).getCount());
			}
			iterator++;
		}
		return result;
	}
}
