package lt.romas.esms.service;

import java.util.List;

import lt.romas.esms.data.entity.ProductGroup;

public interface ProductGroupService {

	List<ProductGroup> findTop();

	List<ProductGroup> findByParentId(int parentId);
}
