package de.hhu.stups.propra.orm.uni.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "profs")
@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long nr;

	@ManyToMany(mappedBy = "meh")
	private List<Professor> profs;

}

