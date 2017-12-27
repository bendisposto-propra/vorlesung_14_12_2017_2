package de.hhu.stups.propra.orm.uni.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "stammdaten")
@Entity
public class BuchExemplar {

	@Id
	@GeneratedValue
	private Long exemplarId;
	private String signatur;

	@ManyToOne
	@JoinColumn(name = "stammdaten")
	private Buch stammdaten;

}


