package lt.romas.esms.service;

import java.util.List;

import lt.romas.esms.data.entity.ProductCharacteristic;

public interface ProductCharacteristicService {

	public List<ProductCharacteristic> findByProductId(int productId);

	public List<ProductCharacteristic> findAll(int page, int size);

	public ProductCharacteristic findOne(int id);
}
