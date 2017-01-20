package lt.romas.esms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
	public void createTopGroups() {
		List<ProductGroup> groups = new ArrayList<>();
		IntStream.range(1, 11).forEach(i -> {
			ProductGroup group = new ProductGroup();
			group.setName("Group " + i);
			groups.add(group);
		});
		productGroupDAO.save(groups);
	}

	@Override
	public void createSubGroups(int parentId, int start, int max) {
		List<ProductGroup> groups = new ArrayList<>();
		ProductGroup parent = productGroupDAO.findOne(parentId);
		if (parent == null) {
			throw new RuntimeException("Parent Group [ID=" + parentId + "] does no exist.");
		}
		IntStream.range(start, start + 10).forEach(i -> {
			ProductGroup group = new ProductGroup();
			group.setName("Sub Group " + i);
			group.setParentId(parentId);
			group.setPath((parent.getPath() == null ? "" : parent.getPath() + ".") + parentId);
			groups.add(group);
		});
		productGroupDAO.save(groups);
	}

	@Override
	public List<ProductGroup> findTop() {
		return productGroupDAO.findTop();
	}

	@Override
	public List<ProductGroup> findByParentId(int parentId) {
		return productGroupDAO.findByParentId(parentId);
	}
}
