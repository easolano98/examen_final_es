package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.ContadorAsientos;
import com.example.demo.repository.modelo.VueloSencillo;

public interface IGestorVuelosService {
	public List<VueloSencillo>consultaDisponibles(String Origen, String Destino, LocalDateTime fecha);
	
	
	public ContadorAsientos reserva(String numeroVuelo, Integer cantidadAsientos, String cedula);
	
	

	

}
