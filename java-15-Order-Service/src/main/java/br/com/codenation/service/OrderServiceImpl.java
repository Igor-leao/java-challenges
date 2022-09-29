package br.com.codenation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		Double orderValue = 0.00;
		Double discount = 0.80;
		Double valueProduct = 0.00;

		for (OrderItem item: items) {
			Boolean isSale = this.productRepository.findById(item.getProductId()).get().getIsSale();

			if (isSale) {
				valueProduct = this.productRepository.findById(item.getProductId()).get().getValue() * discount;
			} else {
				valueProduct = this.productRepository.findById(item.getProductId()).get().getValue();
			}
			Long orderQty = item.getQuantity();
			orderValue += valueProduct * orderQty;
		}

		return orderValue;
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
				.filter(id -> this.productRepository.findById(id).isPresent())
				.map(id -> this.productRepository.findById(id).get())
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderItem>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		Double totalOrders = 0.00;

		for (List<OrderItem> orderList : orders) {
			totalOrders += calculateOrderValue(orderList);
		}
		return totalOrders;
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		Map<Boolean, List<Product>> productMap = new HashMap<Boolean, List<Product>>();

		List<Product> productList = productIds.stream()
				.map(id -> this.productRepository.findById(id)
				.get()).collect(Collectors.toList());

		List<Product> productsIsSaleTrue = productList.stream()
				.filter(product -> product.getIsSale().equals(true))
				.collect(Collectors.toList());

		List<Product> productsIsSaleFalse = productList.stream()
				.filter(product -> product.getIsSale().equals(false))
				.collect(Collectors.toList());

		productMap.put(true,productsIsSaleTrue);
		productMap.put(false, productsIsSaleFalse);

		return productMap;
	}

}