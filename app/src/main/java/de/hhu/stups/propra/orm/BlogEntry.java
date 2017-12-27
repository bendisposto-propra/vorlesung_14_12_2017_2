package de.hhu.stups.propra.orm;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class BlogEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String text;

	public BlogEntry() {
		this.date = Calendar.getInstance().getTime();
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

}
