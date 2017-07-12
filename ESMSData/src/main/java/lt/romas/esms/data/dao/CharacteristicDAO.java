package lt.romas.esms.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.romas.esms.data.entity.Characteristic;

public interface CharacteristicDAO extends JpaRepository<Characteristic, Integer> {
}
