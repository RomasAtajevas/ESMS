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

import lt.romas.esms.common.exception.ProductUnitNotFoundException;
import lt.romas.esms.data.entity.ProductUnit;
import lt.romas.esms.service.ProductUnitService;
import lt.romas.esms.web.dto.ProductUnitDTO;

@RestController
@RequestMapping(value = "productUnit")
public class ProductUnitController {

	private static final Logger logger = LoggerFactory.getLogger(ProductUnitController.class);

	@Autowired
	private ProductUnitService productUnitService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "findAll/{page}/{size}", method = RequestMethod.GET)
	private ResponseEntity<List<ProductUnitDTO>> findAll(@PathVariable("page") int page,
			@PathVariable("size") int size) {
		try {
			List<ProductUnit> units = productUnitService.findAll(page, size);
			List<ProductUnitDTO> dtos = units.stream().map(unit -> modelMapper.map(unit, ProductUnitDTO.class))
					.collect(Collectors.toList());
			return new ResponseEntity<>(dtos, HttpStatus.OK);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "findOne/{id}", method = RequestMethod.GET)
	private ResponseEntity<?> findOne(@PathVariable("id") int id) {
		try {
			ProductUnit unit = productUnitService.findOne(id);
			ProductUnitDTO dto = modelMapper.map(unit, ProductUnitDTO.class);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (ProductUnitNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
