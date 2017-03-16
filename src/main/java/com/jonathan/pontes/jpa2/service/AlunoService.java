package com.jonathan.pontes.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jonathan.pontes.jpa2.dao.AlunoDAO;
import com.jonathan.pontes.jpa2.model.Aluno;
import com.jonathan.pontes.jpa2.util.jpa.Transactional;


public class AlunoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AlunoDAO alunoDAO;
	
	@Transactional
	public void salvar(Aluno aluno) throws NegocioException {
		if (aluno.getNome() == null || aluno.getNome().trim().equals("")) { 
			throw new NegocioException("O nome do Aluno é obrigatório");
		}
		
		this.alunoDAO.salvar(aluno);
	}
	
}
