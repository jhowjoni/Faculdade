package com.jonathan.pontes.jpa2.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula {
	
	private Long codigo;
	
	private Turma turma;
	private Aluno aluno;
	private Professor professor;
	private FormaPagamento formapagamento;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_turma")
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_forma_pagamento")
	public FormaPagamento getFormapagamento() {
		return formapagamento;
	}

	public void setFormapagamento(FormaPagamento formapagamento) {
		this.formapagamento = formapagamento;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_aluno")
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_professor")
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
	
}
