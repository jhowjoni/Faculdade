package com.jonathan.pontes.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jonathan.pontes.jpa2.model.Aluno;
import com.jonathan.pontes.jpa2.service.AlunoService;
import com.jonathan.pontes.jpa2.service.NegocioException;
import com.jonathan.pontes.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroAlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoService alunoService;
	
	@Inject
	private FacesMessages facesMessages;
	
	private Aluno aluno;
	
	public void salvar() {
		try {
			this.alunoService.salvar(aluno);
			facesMessages.info("Aluno salvo com sucesso!");
			
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
		this.aluno = new Aluno();
	}
	

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
