package lt.romas.esms.data.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(indexes = { @Index(columnList = "groupId") })
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "groupId", referencedColumnName = "id", nullable = false)
	private ProductGroup productGroup;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal cost;

	@Column(nullable = false)
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "unitId", referencedColumnName = "id", nullable = false)
	private ProductUnit productUnit;
}
