package com.example.demo34.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "PRODUCT_TBL")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "p_id")
	private int id;
	private String productName;
	@Temporal(TemporalType.DATE)
	private Date manufacturingDate;
	private String description;

	// @OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER, cascade =
	// CascadeType.ALL)
	// @JoinColumn(name = "p_id", referencedColumnName = "id")
	// private Customer customer;
}
