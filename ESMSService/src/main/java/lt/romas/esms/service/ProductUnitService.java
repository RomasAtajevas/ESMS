package lt.romas.esms.service;

import java.util.List;

import lt.romas.esms.data.entity.ProductUnit;

public interface ProductUnitService {

	public List<ProductUnit> findAll(int page, int size);

	public ProductUnit findOne(int id);
}
