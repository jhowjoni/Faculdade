package com.jonathan.pontes.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jonathan.pontes.jpa2.model.Aluno;
import com.jonathan.pontes.jpa2.service.NegocioException;
import com.jonathan.pontes.jpa2.util.jpa.Transactional;


public class AlunoDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(Aluno aluno) {
		em.merge(aluno);
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> buscarTodos() {
		return em.createQuery("from Aluno").getResultList();
	}

	@Transactional
	public void excluir(Aluno aluno) throws NegocioException {
		aluno = em.find(Aluno.class, aluno.getCodigo());
		
	try{	
		em.remove(aluno);
		em.flush();
	} catch (PersistenceException e) {
		throw new NegocioException("Especialidade não pode ser excluída.");
	}
	}

	public Aluno buscarPeloCodigo(Long codigo) {
		return em.find(Aluno.class, codigo);
	}
	
}
