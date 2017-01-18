package lt.romas.esms.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lt.romas.esms.data.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.productGroup.id = :groupId ORDER BY p.name ASC")
	List<Product> findByGroupId(@Param("groupId") Integer groupId);
}
