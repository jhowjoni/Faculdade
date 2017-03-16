package com.jonathan.pontes.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jonathan.pontes.jpa2.model.Especialidade;
import com.jonathan.pontes.jpa2.service.EspecialidadeService;
import com.jonathan.pontes.jpa2.service.NegocioException;
import com.jonathan.pontes.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroEspecialidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EspecialidadeService especialidadeService;
	
	@Inject
	private FacesMessages facesMessages;
	
	private Especialidade especialidade;
	
	public void salvar() {
		try {
			this.especialidadeService.salvar(especialidade);
			facesMessages.info("Especialidade salva com sucesso!");
			
			this.limpar();
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}
	
	@PostConstruct
	public void init() {
		this.limpar();
	}
	
	public void limpar() {
		this.especialidade = new Especialidade();
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	

}



