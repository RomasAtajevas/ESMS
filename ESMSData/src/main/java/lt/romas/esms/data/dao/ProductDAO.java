package lt.romas.esms.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import lt.romas.esms.data.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	public List<Product> findByProductGroupId(@Param("id") int id);
}
