package lt.romas.esms.web.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.romas.esms.common.exception.ProductNotFoundException;
import lt.romas.esms.data.entity.Product;
import lt.romas.esms.service.ProductService;
import lt.romas.esms.web.dto.ProductDTO;

@RestController
@RequestMapping(value = "product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "findByGroupId/{groupId}", method = RequestMethod.GET)
	private ResponseEntity<List<ProductDTO>> findByGroupId(@PathVariable("groupId") int groupId) {
		try {
			List<Product> products = productService.findByGroupId(groupId);
			ModelMapper mapper = new ModelMapper();
			List<ProductDTO> dtos = products.stream().map(product -> mapper.map(product, ProductDTO.class))
					.collect(Collectors.toList());
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "findAll/{page}/{size}", method = RequestMethod.POST)
	private ResponseEntity<List<Product>> findAll(@PathVariable("page") int page, @PathVariable("size") int size) {
		try {
			List<Product> products = productService.findAll(page, size);
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "findOne/{id}", method = RequestMethod.GET)
	private ResponseEntity<?> findOne(@PathVariable("id") int id) {
		try {
			Product product = productService.findOne(id);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
