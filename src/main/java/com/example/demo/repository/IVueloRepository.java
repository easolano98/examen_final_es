package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.repository.modelo.Vuelo;
import com.example.demo.repository.modelo.VueloSencillo;

public interface IVueloRepository {
	public void insertar(Vuelo vuelo);
	
	public List<VueloSencillo> buscar(String origen, String destino, LocalDateTime fecha);
	
	public Vuelo buscar(String numero);
	
	public void actualizar(Vuelo vuelo);
	
}
