package lt.romas.esms.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.romas.esms.data.entity.ProductUnit;

public interface ProductUnitDAO extends JpaRepository<ProductUnit, Integer> {
}
