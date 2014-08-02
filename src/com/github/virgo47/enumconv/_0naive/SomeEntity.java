package com.github.virgo47.enumconv._0naive;

import com.github.virgo47.enumconv._2framework.SomeEntityType;
import com.github.virgo47.enumconv._2framework.SomeEntityTypeConverter;

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
