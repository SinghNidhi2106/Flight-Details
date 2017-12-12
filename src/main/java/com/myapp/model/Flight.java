package com.myapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="JPA_FLIGHT")
public class Flight {
	public Flight(String airlines, Date depTime, Date arrivalTime, String fromAirport, String toAirport) {
		super();
		this.airlines = airlines;
		this.depTime = depTime;
		this.arrivalTime = arrivalTime;
		this.fromAirport = fromAirport;
		this.toAirport = toAirport;
	}

	@Id
	@Column(name = "FLIGHT_NUMBER")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String airlines;

	@Temporal(TemporalType.TIME)
	private Date depTime;
	@Temporal(TemporalType.TIME)
	private Date arrivalTime;

	private String fromAirport;
	private String toAirport;
	
	private int miles;

	public Flight(String airlines, Date depTime, Date arrivalTime, String fromAirport, String toAirport, int miles) {
		super();
		this.airlines = airlines;
		this.depTime = depTime;
		this.arrivalTime = arrivalTime;
		this.fromAirport = fromAirport;
		this.toAirport = toAirport;
		this.miles = miles;
	}

	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

	public Date getDepTime() {
		return depTime;
	}

	public void setDepTime(Date depTime) {
		this.depTime = depTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFromAirport() {
		return fromAirport;
	}

	public void setFromAirport(String fromAirport) {
		this.fromAirport = fromAirport;
	}

	public String getToAirport() {
		return toAirport;
	}

	public void setToAirport(String toAirport) {
		this.toAirport = toAirport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airlines == null) ? 0 : airlines.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (airlines == null) {
			if (other.airlines != null)
				return false;
		} else if (!airlines.equals(other.airlines))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [id=");
		builder.append(id);
		builder.append(", airlines=");
		builder.append(airlines);
		builder.append(", depTime=");
		builder.append(depTime);
		builder.append(", arrivalTime=");
		builder.append(arrivalTime);
		builder.append(", fromAirport=");
		builder.append(fromAirport);
		builder.append(", toAirport=");
		builder.append(toAirport);
		builder.append("]");
		return builder.toString();
	}

}
