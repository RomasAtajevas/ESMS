package lt.romas.esms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.romas.esms.common.exception.ProductUnitNotFoundException;
import lt.romas.esms.data.dao.ProductUnitDAO;
import lt.romas.esms.data.entity.ProductUnit;
import lt.romas.esms.service.ProductUnitService;

@Service
@Transactional
public class ProductUnitServiceImpl implements ProductUnitService {

	@Autowired
	private ProductUnitDAO productUnitDAO;

	@Override
	public List<ProductUnit> findAll(int page, int size) {
		Page<ProductUnit> units = productUnitDAO
				.findAll(new PageRequest(page, size, new Sort(Sort.Direction.ASC, "name")));
		return units.getContent();
	}

	@Override
	public ProductUnit findOne(int id) {
		ProductUnit unit = productUnitDAO.findOne(id);
		if (unit == null) {
			throw new ProductUnitNotFoundException("ProductUnit [id=" + id + "] not found.");
		}
		return unit;
	}
}
