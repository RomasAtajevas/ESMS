package lt.romas.esms.service;

import java.util.List;

import lt.romas.esms.data.entity.Product;

public interface ProductService {

	List<Product> findByGroupId(int groupId);
}
