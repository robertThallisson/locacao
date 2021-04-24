package com.locacao.except;

public class LocacaoException extends RuntimeException {
	public LocacaoException(String mensagemUsuario) {
		// TODO Auto-generated constructor stub
		this.mensagemUsuario = mensagemUsuario;
	}
	public LocacaoException(String mensagemUsuario,String mensagemPadrao) {
		// TODO Auto-generated constructor stub
		this.mensagemUsuario = mensagemUsuario;
		this.mensagemPadrao = mensagemPadrao;
	}
	public LocacaoException() {
		// TODO Auto-generated constructor stub
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensagemUsuario;
	private String mensagemPadrao;
	public String getMensagemUsuario() {
		return mensagemUsuario;
	}
	public void setMensagemUsuario(String mensagemUsuario) {
		this.mensagemUsuario = mensagemUsuario;
	}
	public String getMensagemPadrao() {
		return mensagemPadrao;
	}
	public void setMensagemPadrao(String mensagemPadrao) {
		this.mensagemPadrao = mensagemPadrao;
	}

}
