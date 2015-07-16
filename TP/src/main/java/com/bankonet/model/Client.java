package com.bankonet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Client {

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

private String nom;

public Client() {
}

public Client(String nom){
	this.setNom(nom);
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}







}
