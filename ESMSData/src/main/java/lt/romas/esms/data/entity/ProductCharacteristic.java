package lt.romas.esms.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "productId", "characteristicId" }) })
public class ProductCharacteristic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private int productId;

	@ManyToOne
	@JoinColumn(name = "characteristicId", referencedColumnName = "id", nullable = false)
	private Characteristic characteristic;

	@Column(nullable = false)
	private String value;
}
