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

import lt.romas.esms.common.exception.ProductCharacteristicNotFoundException;
import lt.romas.esms.data.entity.ProductCharacteristic;
import lt.romas.esms.service.ProductCharacteristicService;

@RestController
@RequestMapping(value = "productCharacteristic")
public class ProductCharacteristicController {

	private static final Logger logger = LoggerFactory.getLogger(ProductCharacteristicController.class);

	@Autowired
	private ProductCharacteristicService productCharacteristicService;

	@RequestMapping(value = "findByProductId/{productId}", method = RequestMethod.GET)
	private ResponseEntity<List<ProductCharacteristic>> findByProductId(@PathVariable("productId") int productId) {
		try {
			List<ProductCharacteristic> characteristics = productCharacteristicService.findByProductId(productId);
			return new ResponseEntity<>(characteristics, HttpStatus.OK);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "findAll/{page}/{size}", method = RequestMethod.GET)
	private ResponseEntity<List<ProductCharacteristic>> findAll(@PathVariable("page") int page,
			@PathVariable("size") int size) {
		try {
			List<ProductCharacteristic> characteristics = productCharacteristicService.findAll(page, size);
			return new ResponseEntity<>(characteristics, HttpStatus.OK);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "findOne/{id}", method = RequestMethod.GET)
	private ResponseEntity<?> findOne(@PathVariable("id") int id) {
		try {
			ProductCharacteristic characteristics = productCharacteristicService.findOne(id);
			return new ResponseEntity<>(characteristics, HttpStatus.OK);
		} catch (ProductCharacteristicNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
