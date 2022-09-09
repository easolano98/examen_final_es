package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICompraPasajeRepository;
import com.example.demo.repository.IVueloRepository;
import com.example.demo.repository.modelo.CompraPasaje;
import com.example.demo.repository.modelo.ContadorAsientos;
import com.example.demo.repository.modelo.Vuelo;
import com.example.demo.repository.modelo.VueloSencillo;

@Service
public class GestorVuelosServiceImpl implements IGestorVuelosService{
	
	@Autowired
	private IVueloRepository vueloRepository;
	
	@Autowired
	private ICompraPasajeRepository compraPasaje;
	
	
	@Override
	public List<VueloSencillo> consultaDisponibles(String origen, String destino, LocalDateTime fecha) {
		// TODO Auto-generated method stub	
	List<VueloSencillo> disponibles = this.vueloRepository.buscar(origen, destino, fecha);
	List<VueloSencillo> consulta = disponibles.stream().filter(i -> i.getFechaD().equals(fecha) && i.getEstado().equals("Dis")).collect(Collectors.toList());

	return consulta;
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public ContadorAsientos reserva(String numeroVuelo, Integer cantidadAsientos, String cedula) {
		// TODO Auto-generated method stub
		
		Vuelo vuelo = this.vueloRepository.buscar(numeroVuelo);
		CompraPasaje compra = new CompraPasaje();
		ContadorAsientos contador = new ContadorAsientos();
		
		contador.setAsientosDisponibles(vuelo.getAsientosDisponibles());
		contador.setAsientosTotales(vuelo.getAvion().getCapacidadAsientos());
		contador.setAsientosOcupados(contador.getAsientosTotales() - contador.getAsientosDisponibles());
		contador.setAsientosDisponibles(contador.getAsientosDisponibles() - cantidadAsientos);
		contador.setAsientosOcupados(contador.getAsientosOcupados() + cantidadAsientos);
		
		
		if (vuelo.getEstado().equals("Dis") && cantidadAsientos <= contador.getAsientosDisponibles()) {
			compra.setAsientosComprados(cantidadAsientos);
			compra.setFechaCompra(LocalDateTime.now());
			compra.setEstado("RES");
			compra.setVuelo(vuelo);
			
			vuelo.setAsientosDisponibles(contador.getAsientosDisponibles());
			if (contador.getAsientosDisponibles() == 0) {
				vuelo.setEstado("ND");
			}
			this.vueloRepository.actualizar(vuelo);
			this.compraPasaje.insertar(compra);
			
		}

		return contador;
		
	
	}
	
		
		
	}
	
	
	
	

