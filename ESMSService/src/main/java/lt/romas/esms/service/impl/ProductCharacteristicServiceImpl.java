package lt.romas.esms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.romas.esms.common.exception.ProductCharacteristicNotFoundException;
import lt.romas.esms.data.dao.ProductCharacteristicDAO;
import lt.romas.esms.data.entity.ProductCharacteristic;
import lt.romas.esms.service.ProductCharacteristicService;

@Service
@Transactional
public class ProductCharacteristicServiceImpl implements ProductCharacteristicService {

	@Autowired
	private ProductCharacteristicDAO productCharacteristicDAO;

	@Override
	public List<ProductCharacteristic> findByProductId(int productId) {
		return productCharacteristicDAO.findByProductId(productId);
	}

	@Override
	public List<ProductCharacteristic> findAll(int page, int size) {
		Page<ProductCharacteristic> characteristics = productCharacteristicDAO
				.findAll(new PageRequest(page, size, new Sort(Sort.Direction.ASC, "characteristic.name")));
		return characteristics.getContent();
	}

	@Override
	public ProductCharacteristic findOne(int id) {
		ProductCharacteristic characteristic = productCharacteristicDAO.findOne(id);
		if (characteristic == null) {
			throw new ProductCharacteristicNotFoundException("ProductCharacteristic [id=" + id + "] not found.");
		}
		return characteristic;
	}
}
