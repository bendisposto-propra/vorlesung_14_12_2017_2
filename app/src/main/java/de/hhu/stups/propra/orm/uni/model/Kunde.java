package de.hhu.stups.propra.orm.uni.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Kunde {

	@Id
	@GeneratedValue
	private Long kdnr;
	private String name;
	
	@Embedded
	private Adresse adr;

}


