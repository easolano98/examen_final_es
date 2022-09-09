package com.example.demo.repository;

import com.example.demo.repository.modelo.CompraPasaje;

public interface ICompraPasajeRepository {
	public void insertar(CompraPasaje compraPasaje);
	
	public void actualizar(CompraPasaje compraPasaje);
	
	public CompraPasaje buscar(String numero);
}
