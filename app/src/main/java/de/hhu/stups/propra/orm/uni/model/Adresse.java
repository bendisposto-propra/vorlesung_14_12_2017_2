package de.hhu.stups.propra.orm.uni.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Adresse {

	private String strasse;
	private String plz;
	private String stadt;

}


