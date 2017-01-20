package lt.romas.esms.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lt.romas.esms.data.entity.ProductGroup;

public interface ProductGroupDAO extends JpaRepository<ProductGroup, Integer> {

	@Query("SELECT pg FROM ProductGroup pg WHERE pg.parentId IS NULL ORDER BY pg.name ASC")
	List<ProductGroup> findTop();

	@Query("SELECT pg FROM ProductGroup pg WHERE pg.parentId = :parentId ORDER BY pg.name ASC")
	List<ProductGroup> findByParentId(@Param("parentId") int parentId);
}
