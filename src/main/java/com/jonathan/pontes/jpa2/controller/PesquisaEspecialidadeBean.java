package com.jonathan.pontes.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jonathan.pontes.jpa2.dao.EspecialidadeDAO;
import com.jonathan.pontes.jpa2.model.Especialidade;
import com.jonathan.pontes.jpa2.service.NegocioException;
import com.jonathan.pontes.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaEspecialidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EspecialidadeDAO especialidadeDAO;
	
	private List<Especialidade> especialidades;
	
	private Especialidade especialidadeSelecionada;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}
	
	public void excluir() {
		try {
			especialidadeDAO.excluir(especialidadeSelecionada);
			this.especialidades.remove(especialidadeSelecionada);
			facesMessages.info("Especialidade " + especialidadeSelecionada.getDescricao() + " excluído com sucesso.");
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	
	public Especialidade getEspecialidadeSelecionada() {
		return especialidadeSelecionada;
	}

	public void setEspecialidadeSelecionada(Especialidade especialidadeSelecionada) {
		this.especialidadeSelecionada = especialidadeSelecionada;
	}

	public void inicializar() {
		especialidades = especialidadeDAO.buscarTodos();
	}
}