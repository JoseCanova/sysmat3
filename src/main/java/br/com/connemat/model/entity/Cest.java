package br.com.connemat.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;

@Valid
@Entity
public class Cest extends CestBase {

	protected static final long serialVersionUID = -2270676434436349360L;

	@Id
	@Column(name="cest_code")
	private String id;
	
	/*
	 * @Column(name="description" , columnDefinition = "VARCHAR(1200) NOT NULL")
	 * 
	 * @NotEmpty(groups= {CreateValidationGroup.class ,
	 * UpdateValidationGroup.class})
	 * 
	 * @Size(max=1200 , groups= {CreateValidationGroup.class ,
	 * UpdateValidationGroup.class}) protected String description;
	 * 
	 * @NotNull(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	 * 
	 * @Column(name="start_date" , columnDefinition = "DATE NOT NULL")
	 * 
	 * @PastOrPresent(groups= {CreateValidationGroup.class ,
	 * UpdateValidationGroup.class}) protected LocalDate startDate;
	 * 
	 * @Column(name="end_date" , columnDefinition = "DATE")
	 * 
	 * @PastOrPresent(groups= {CreateValidationGroup.class ,
	 * UpdateValidationGroup.class}) protected LocalDate endDate;
	 * 
	 * @NotNull(groups= {CreateValidationGroup.class , UpdateValidationGroup.class})
	 * 
	 * @BaseConstraint(groups= {CreateValidationGroup.class ,
	 * UpdateValidationGroup.class})
	 * 
	 * @JsonSerialize(using = JsonBaseSerializer.class)
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="cest_tree_id") protected CestTree cestTree;
	 * 
	 * @BaseConstraint(groups= {CreateValidationGroup.class ,
	 * UpdateValidationGroup.class})
	 * 
	 * @JsonSerialize(using = JsonBaseSerializer.class)
	 * 
	 * @ManyToOne
	 * 
	 * @JoinTable(name="cest_has_ncm", joinColumns = @JoinColumn(name="cest_code" ,
	 * referencedColumnName = "cest_code"), inverseJoinColumns
	 * = @JoinColumn(name="ncm_code" , referencedColumnName = "ncm_code")) protected
	 * Ncm ncm;
	 */
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cest() {
	}

}
