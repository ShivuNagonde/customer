package com.example.demo34.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "USER_REG_TBL")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private String password;
	private String role;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginTime = null;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
}
