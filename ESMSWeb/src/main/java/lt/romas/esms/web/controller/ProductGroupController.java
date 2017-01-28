package lt.romas.esms.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.romas.esms.data.entity.ProductGroup;
import lt.romas.esms.service.ProductGroupService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/productGroup")
public class ProductGroupController {

	@Autowired
	private ProductGroupService productGroupService;

	@RequestMapping(value = "/createGroups", method = RequestMethod.GET)
	private String createTestGroups() {
		productGroupService.createTopGroups();
		productGroupService.createSubGroups(1, 1, 10);
		productGroupService.createSubGroups(11, 11, 20);
		return "Groups were created.";
	}

	@RequestMapping(value = "/findTop", method = RequestMethod.GET)
	private List<ProductGroup> findTop() {
		return productGroupService.findTop();
	}

	@RequestMapping(value = "/findByParentId/{parentId}", method = RequestMethod.GET)
	private List<ProductGroup> findByParentId(@PathVariable("parentId") Integer parentId) {
		return productGroupService.findByParentId(parentId);
	}
}
