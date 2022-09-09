package com.example.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VueloSencillo {

	private String numeroVuelo;
	private String Estado;
	private String Origen;
	private String Destino;
	private String nombreAvion;
	private BigDecimal valorAsiento;
	private String fecha;
	private LocalDateTime fechaD;

	public VueloSencillo() {

	}

	public VueloSencillo(String numeroVuelo, String origen, String destino, String nombreAvion,
			BigDecimal valorAsiento) {
		super();
		this.numeroVuelo = numeroVuelo;
		Origen = origen;
		Destino = destino;

		this.nombreAvion = nombreAvion;
		this.valorAsiento = valorAsiento;
		this.fechaD = LocalDateTime.parse(fecha);
	}

	// GET y SET
	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getOrigen() {
		return Origen;
	}

	public void setOrigen(String origen) {
		Origen = origen;
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public String getNombreAvion() {
		return nombreAvion;
	}

	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}

	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}

	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public LocalDateTime getFechaD() {
		return fechaD;
	}

	public void setFechaD(LocalDateTime fechaD) {
		this.fechaD = fechaD;
	}

}
