package com.example.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CompraPasaje;

@Repository
@Transactional
public class ComprarPasajeRepositoryImpl implements ICompraPasajeRepository{
	
	@Autowired
	private EntityManager entityManager;
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void insertar(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.persist(compraPasaje);
	}
	@Override
	@Transactional(value=TxType.MANDATORY)
	public void actualizar(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.entityManager.merge(compraPasaje);
	}

	@Override
	@Transactional(value=TxType.NOT_SUPPORTED)
	public CompraPasaje buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CompraPasaje>query=this.entityManager.createQuery("SELECT p FROM CompraPasaje p WHERE p.numero=:datoNumero",CompraPasaje.class);
		query.setParameter("datoNumero", numero);
		return query.getSingleResult();
	}
	
	
}
