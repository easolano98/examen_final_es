package com.example.demo.repository.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "compra_pasaje")
public class CompraPasaje {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "copa_id_seq")
	@SequenceGenerator(name = "copa_id_seq", sequenceName = "copa_id_seq", allocationSize = 1)
	@Column(name = "copa_id")
	private Integer id;
	@Column(name = "copa_numero")
	private String numero;
	@Column(name = "copa_fecha_compra")
	private LocalDateTime fechaCompra;
	@Column(name = "copa_asientos_comprados")
	private Integer asientosComprados;
	@Column(name = "copa_estado")
	private String estado;

	@ManyToOne()
	@JoinColumn(name = "copa_vuel_id")
	private Vuelo vuelo;

	@ManyToOne()
	@JoinColumn(name = "copa_clie_id")
	private Cliente cliente;

	// GET y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Integer getAsientosComprados() {
		return asientosComprados;
	}

	public void setAsientosComprados(Integer asientosComprados) {
		this.asientosComprados = asientosComprados;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
