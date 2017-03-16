package com.jonathan.pontes.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jonathan.pontes.jpa2.model.Especialidade;
import com.jonathan.pontes.jpa2.service.NegocioException;
import com.jonathan.pontes.jpa2.util.jpa.Transactional;

public class EspecialidadeDAO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(Especialidade especialidade) {
		em.merge(especialidade);
	}

	@SuppressWarnings("unchecked")
	public List<Especialidade> buscarTodos() {
		return em.createQuery("from Especialidade").getResultList();
	}

	@Transactional
	public void excluir(Especialidade especialidade) throws NegocioException {
		especialidade = em.find(Especialidade.class, especialidade.getCodigo());
		
		try {
			em.remove(especialidade);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Especialidade não pode ser excluída.");
		}
	}

	public Especialidade buscarPeloCodigo(Long codigo) {
		return em.find(Especialidade.class, codigo);
	}
	
}