package de.hhu.stups.propra.orm.uni.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Buch {

	@Id
	@GeneratedValue
	private Long id;
	private String titel;
	private String autor;

	@OneToMany(mappedBy = "stammdaten", 
			   fetch = FetchType.EAGER, 
			   cascade = CascadeType.ALL)
	private List<BuchExemplar> exemplare;

}



