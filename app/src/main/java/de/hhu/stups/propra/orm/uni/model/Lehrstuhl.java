package de.hhu.stups.propra.orm.uni.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "professor")
@Entity
public class Lehrstuhl {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@OneToOne(mappedBy = "lehrstuhl")
	private Professor professor;

	@Enumerated
	private Fakultaet fakultaet;
}


