package lt.romas.esms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<ProductGroup> findByParentId(Integer parentId) {
		return productGroupDAO.findByParentId(parentId);
	}
}
