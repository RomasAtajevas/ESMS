package lt.romas.esms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.romas.esms.common.exception.ProductNotFoundException;
import lt.romas.esms.data.dao.ProductDAO;
import lt.romas.esms.data.entity.Product;
import lt.romas.esms.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> findByGroupId(int groupId) {
		return productDAO.findByProductGroupId(groupId);
	}

	@Override
	public List<Product> findAll(int page, int size) {
		Page<Product> products = productDAO.findAll(new PageRequest(page, size, new Sort(Sort.Direction.ASC, "name")));
		return products.getContent();
	}

	@Override
	public Product findOne(int id) {
		Product product = productDAO.findOne(id);
		if (product == null) {
			throw new ProductNotFoundException("Product [id=" + id + "] not found.");
		}
		return product;
	}
}
