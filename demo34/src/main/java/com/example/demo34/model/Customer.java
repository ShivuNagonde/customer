package com.example.demo34.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "CUS_REG_TBL")
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	private String customerName;
	private String contactPersonName;
	private String mobileNo;
	private String email;
	private String address;
	private Date createdAt;
	private String productName;

	// @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// private Product product;
}
