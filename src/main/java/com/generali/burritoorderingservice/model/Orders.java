package com.generali.burritoorderingservice.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Orders{
	
	@Id
	@GeneratedValue
	private Long id;
	private String tortilla;
	private String protein;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "order")
    private Set<Vegetables> vegetables = new HashSet<Vegetables>();
	private String salsa;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "order")
	private Set<Extras> extras = new HashSet<Extras>();
}
