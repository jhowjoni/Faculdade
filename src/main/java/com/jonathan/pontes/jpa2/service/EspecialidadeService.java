package com.jonathan.pontes.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.jonathan.pontes.jpa2.dao.EspecialidadeDAO;
import com.jonathan.pontes.jpa2.model.Especialidade;
import com.jonathan.pontes.jpa2.util.jpa.Transactional;

public class EspecialidadeService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EspecialidadeDAO especialidadeDAO;
	
	@Transactional
	public void salvar(Especialidade especialidade) throws NegocioException {
		if (especialidade.getDescricao() == null || especialidade.getDescricao().trim().equals("")) { 
			throw new NegocioException("A descrição da especialidade é obrigatória!");
		}
		
		this.especialidadeDAO.salvar(especialidade);
	}

}
