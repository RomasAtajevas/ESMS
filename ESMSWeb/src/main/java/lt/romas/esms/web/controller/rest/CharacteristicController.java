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
import lt.romas.esms.data.entity.Characteristic;
import lt.romas.esms.service.CharacteristicService;
import lt.romas.esms.web.dto.CharacteristicDTO;

@RestController
@RequestMapping(value = "characteristic")
public class CharacteristicController {

	private static final Logger logger = LoggerFactory.getLogger(CharacteristicController.class);

	@Autowired
	private CharacteristicService characteristicService;

	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(value = "findAll/{page}/{size}", method = RequestMethod.GET)
	private ResponseEntity<List<CharacteristicDTO>> findAll(@PathVariable("page") int page,
			@PathVariable("size") int size) {
		try {
			List<Characteristic> characteristics = characteristicService.findAll(page, size);
			List<CharacteristicDTO> dtos = characteristics.stream()
					.map(characteristic -> modelMapper.map(characteristic, CharacteristicDTO.class))
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
			Characteristic characteristic = characteristicService.findOne(id);
			CharacteristicDTO dto = modelMapper.map(characteristic, CharacteristicDTO.class);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (ProductUnitNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
