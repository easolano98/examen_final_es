package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vuelo;
import com.example.demo.repository.modelo.VueloSencillo;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository {
	@Autowired
	private EntityManager entityManager;
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vuelo);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<VueloSencillo> buscar(String origen, String destino, LocalDateTime fecha) {
		// TODO Auto-generated method stub
		TypedQuery<VueloSencillo> query = this.entityManager.createQuery("SELECT new com.example.demo.repository.modelo.VueloSencillo(v.numero, v.origen, v.destino, v.nombre, v.valorAsiento) FROM Vuelo v, Avion a WHERE v.origen=:datoOrigen AND v.destino=:datoDestino",
				VueloSencillo.class);
		query.setParameter("datoOrigen", origen);
		query.setParameter("datoDestino", destino);
		return query.getResultList();
	}
	
	@Override
	public Vuelo buscar(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo>query =this.entityManager.createQuery("SELECT v FROM Vuelo v WHERE v.numero=:datoNumero", Vuelo.class);
		query.setParameter("datoNumero", numero);
		Vuelo vuelo=query.getSingleResult();
		vuelo.getAvion().getCapacidadAsientos();
		return vuelo;
	}
	@Override
	public void actualizar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vuelo);
	}
	
	
}
