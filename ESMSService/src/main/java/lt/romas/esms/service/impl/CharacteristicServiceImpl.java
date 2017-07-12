package lt.romas.esms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.romas.esms.common.exception.CharacteristicNotFoundException;
import lt.romas.esms.data.dao.CharacteristicDAO;
import lt.romas.esms.data.entity.Characteristic;
import lt.romas.esms.service.CharacteristicService;

@Service
@Transactional
public class CharacteristicServiceImpl implements CharacteristicService {

	@Autowired
	private CharacteristicDAO characteristicDAO;

	@Override
	public List<Characteristic> findAll(int page, int size) {
		Page<Characteristic> characteristics = characteristicDAO
				.findAll(new PageRequest(page, size, new Sort(Sort.Direction.ASC, "name")));
		return characteristics.getContent();
	}

	@Override
	public Characteristic findOne(int id) {
		Characteristic characteristic = characteristicDAO.findOne(id);
		if (characteristic == null) {
			throw new CharacteristicNotFoundException("Characteristic [id=" + id + "] not found.");
		}
		return characteristic;
	}
}
