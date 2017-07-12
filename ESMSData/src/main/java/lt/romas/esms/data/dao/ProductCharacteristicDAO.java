package lt.romas.esms.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lt.romas.esms.data.entity.ProductCharacteristic;

public interface ProductCharacteristicDAO extends JpaRepository<ProductCharacteristic, Integer> {

	@Query("SELECT pc FROM ProductCharacteristic pc WHERE pc.product.id = :productId")
	public List<ProductCharacteristic> findByProductId(@Param("productId") int productId);
}
