// Natasha da Silva Alves - Natasha.Alves@recode.org.br
package br.com.agenciaViagens.model;


public class Destino {
	
	private int idDestino;
	private String origem;
	private String destino;
	private String dataIda;
	private String dataVolta;
	private String formaDePagamento;
	
	
	public Destino(int idDestino, String origem, String destino, String dataIda, String dataVolta, String formaDePagamento) {
		super();
		this.idDestino = idDestino;
		this.origem = origem;
		this.destino = destino;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.formaDePagamento = formaDePagamento;
	}
	
	
	public Destino() {
		
	} 
	

	public int getIdDestino() {
		return idDestino;
	}


	public void setIdDestino(int idDestino) {
		this.idDestino = idDestino;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getDataIda() {
		return dataIda;
	}


	public void setDataIda(String dataIda) {
		this.dataIda = dataIda;
	}


	public String getDataVolta() {
		return dataVolta;
	}


	public void setDataVolta(String dataVolta) {
		this.dataVolta = dataVolta;
	}


	public String getFormaDePagamento() {
		return formaDePagamento;
	}


	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
    
}
