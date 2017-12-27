package de.hhu.stups.propra.orm.uni.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Professor {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	private Lehrstuhl lehrstuhl;

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "faceless_mob", 
	           joinColumns = { @JoinColumn(name = "id") }, 
	           inverseJoinColumns = {@JoinColumn(name = "nr") })
	List<Student> meh;

}


