package lt.romas.esms.service;

import java.util.List;

import lt.romas.esms.data.entity.ProductGroup;

public interface ProductGroupService {

	void createTopGroups();

	void createSubGroups(int parentId, int start, int max);

	List<ProductGroup> findTop();

	List<ProductGroup> findByParentId(int parentId);
}
