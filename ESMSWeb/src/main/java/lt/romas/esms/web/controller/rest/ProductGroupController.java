package lt.romas.esms.web.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.romas.esms.common.exception.ProductGroupNotFoundException;
import lt.romas.esms.data.entity.ProductGroup;
import lt.romas.esms.service.ProductGroupService;

@RestController
@RequestMapping(value = "productGroup")
public class ProductGroupController {

	private static final Logger logger = LoggerFactory.getLogger(ProductGroupController.class);

	@Autowired
	private ProductGroupService productGroupService;

	@RequestMapping(value = "findTop", method = RequestMethod.GET)
	private ResponseEntity<List<ProductGroup>> findTop() {
		try {
			List<ProductGroup> groups = productGroupService.findTop();
			return new ResponseEntity<>(groups, HttpStatus.OK);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "findByParentId/{parentId}", method = RequestMethod.GET)
	private ResponseEntity<List<ProductGroup>> findByParentId(@PathVariable("parentId") int parentId) {
		try {
			List<ProductGroup> groups = productGroupService.findByParentId(parentId);
			return new ResponseEntity<>(groups, HttpStatus.OK);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "findOne/{id}", method = RequestMethod.GET)
	private ResponseEntity<?> findOne(@PathVariable("id") int id) {
		try {
			ProductGroup group = productGroupService.findOne(id);
			return new ResponseEntity<>(group, HttpStatus.OK);
		} catch (ProductGroupNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
