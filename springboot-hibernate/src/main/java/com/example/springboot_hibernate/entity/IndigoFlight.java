package com.example.springboot_hibernate.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "indigo_flights")
public class IndigoFlight {
	@Id
	private int id;
	
	@Column(name = "source_country")
	private String source;
	
	@Column(name = "destination_country")
	private String destination;
	private int price;
	private int availableSeats;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name = "p1_name"), name = "name"),
		@AttributeOverride(column = @Column(name = "p1_age"), name = "age"),
	})
	private Pilot p1;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name = "p2_name"), name = "name"),
		@AttributeOverride(column = @Column(name = "p2_age"), name = "age"),
	})
	private Pilot p2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public Pilot getP1() {
		return p1;
	}
	public void setP1(Pilot p1) {
		this.p1 = p1;
	}
	public Pilot getP2() {
		return p2;
	}
	public void setP2(Pilot p2) {
		this.p2 = p2;
	}
}