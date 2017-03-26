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

	public List<Especialidade> buscarTodos() {
		return em.createQuery("from Especialidade", Especialidade.class).getResultList();
	}

	@Transactional
	public void excluir(Especialidade especialidade) throws NegocioException {
		try {
			Especialidade especialidadeTemp = this.buscarPeloCodigo(especialidade.getCodigo());
		
			em.remove(especialidadeTemp);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Especialidade não pode ser excluído.");
		}
	}

	public Especialidade buscarPeloCodigo(Long codigo) {
		return em.find(Especialidade.class, codigo);
	}
	
}