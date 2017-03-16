package com.jonathan.pontes.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jonathan.pontes.jpa2.model.Matricula;
import com.jonathan.pontes.jpa2.service.NegocioException;
import com.jonathan.pontes.jpa2.util.jpa.Transactional;

public class MatriculaDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(Matricula matricula) {
		em.merge(matricula);
	}

	@SuppressWarnings("unchecked")
	public List<Matricula> buscarTodos() {
		return em.createQuery("from Matricula").getResultList();
	}

	@Transactional
	public void excluir(Matricula matricula) throws NegocioException {
		matricula = em.find(Matricula.class, matricula.getCodigo());
		
		try {
			em.remove(matricula);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("A Matricula não pode ser excluída.");
		}
	}

	public Matricula buscarPeloCodigo(Long codigo) {
		return em.find(Matricula.class, codigo);
	}
	
}
