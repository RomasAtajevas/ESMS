package lt.romas.esms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.romas.esms.common.exception.ProductGroupNotFoundException;
import lt.romas.esms.data.dao.ProductGroupDAO;
import lt.romas.esms.data.entity.ProductGroup;
import lt.romas.esms.service.ProductGroupService;

@Service
@Transactional
public class ProductGroupServiceImpl implements ProductGroupService {

	@Autowired
	private ProductGroupDAO productGroupDAO;

	@Override
	public List<ProductGroup> findTop() {
		return productGroupDAO.findTop();
	}

	@Override
	public List<ProductGroup> findByParentId(int parentId) {
		return productGroupDAO.findByParentId(parentId);
	}

	@Override
	public ProductGroup findOne(int id) {
		ProductGroup group = productGroupDAO.findOne(id);
		if (group == null) {
			throw new ProductGroupNotFoundException("ProductGroup [id=" + id + "] not found.");
		}
		return group;
	}
}
