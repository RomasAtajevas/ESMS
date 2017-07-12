package lt.romas.esms.service;

import java.util.List;

import lt.romas.esms.data.entity.Product;

public interface ProductService {

	public List<Product> findByGroupId(int groupId);

	public List<Product> findAll(int page, int size);

	public Product findOne(int id);
}
