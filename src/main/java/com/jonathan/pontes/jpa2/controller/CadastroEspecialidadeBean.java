package com.jonathan.pontes.jpa2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
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
	
	private Especialidade especialidade;
	
	@Inject
	private FacesMessages facesMessages;
	
	public void init() {
		if (this.especialidade== null) {
			limpar();
		}
	}
	
	public void salvar() {
		try {
			especialidadeService.salvar(especialidade);
			facesMessages.info("Especialidade salvo com sucesso!");
			
			limpar();
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}
	
	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	public boolean isEditando() {
		return this.especialidade.getCodigo() != null;
	}
	
	private void limpar() {
		this.especialidade = new Especialidade();
	}
	
}
