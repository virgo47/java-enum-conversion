package com.github.virgo47.enumconv._1encapsulated;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SomeEntity {

	@Id
	private Integer id;

	@Convert(converter = SomeEntityTypeConverter.class)
	@Column(name = "type")
	private SomeEntityType type;

}
