package lt.romas.esms.service;

import java.util.List;

import lt.romas.esms.data.entity.Characteristic;

public interface CharacteristicService {

	public List<Characteristic> findAll(int page, int size);

	public Characteristic findOne(int id);
}
