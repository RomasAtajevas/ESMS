package lt.romas.esms.service;

import java.util.List;

import lt.romas.esms.data.entity.ProductGroup;

public interface ProductGroupService {

	public List<ProductGroup> findTop();

	public List<ProductGroup> findByParentId(int parentId);

	public ProductGroup findOne(int id);
}
