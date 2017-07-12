package lt.romas.esms.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(indexes = { @Index(columnList = "parentId"), @Index(columnList = "path") })
public class ProductGroup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId", referencedColumnName = "id")
	private ProductGroup parentGroup;

	@Column(unique = true, nullable = false)
	private String name;

	private String path;

	private boolean isParent;
}
