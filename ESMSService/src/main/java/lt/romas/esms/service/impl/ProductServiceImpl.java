package lt.romas.esms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return productDAO.findByGroupId(groupId);
	}
}
