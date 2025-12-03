package TP.cs.cs02.model.lista;

import TP.cs.cs02.model.Iterador;

public class ListaEncadeadaSimples implements ListaEncadeada{

	No noInicial = null;
	int totalDeElementos = 0;
	
	@Override
	public void adicionarInicio(int dado) {
		No novoNo = new No(dado); 
		novoNo.definirProximo(this.noInicial);
		this.noInicial = novoNo;
		this.totalDeElementos++;
	}
	
	@Override
	public void adicionarFim(int dado) {
		No novoNo = new No(dado);
		if (this.noInicial != null) {
			No noAtual = this.noInicial;
			while (noAtual.obterProximo() != null) {
				noAtual = noAtual.obterProximo();
			}			
			noAtual.definirProximo(novoNo);
		}
		else {
			this.noInicial = novoNo;
		}
		this.totalDeElementos++;
	}
	
	@Override
	public boolean adicionarMeio(int posicaoInclusao, int dado) {
		No novoNo = new No(dado);
		No noAtual = this.noInicial;
		No noAnterior = null;
		int posicaoAtual = 0;
			
		while ((noAtual != null) && (posicaoInclusao != posicaoAtual)) {
			noAnterior = noAtual;
			noAtual = noAtual.obterProximo();
			posicaoAtual++;
		}
		
		if (posicaoInclusao == posicaoAtual) {
			if (noAnterior == null) {
				novoNo.definirProximo(this.noInicial);
				this.noInicial = novoNo;
			}
			else {
				noAnterior.definirProximo(novoNo);
				novoNo.definirProximo(noAtual);
			}
			this.totalDeElementos++;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean excluirInicio() {
		if (this.noInicial != null) {
			this.noInicial = this.noInicial.obterProximo();
			this.totalDeElementos--;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean excluirFim() {
		No noAtual = this.noInicial;
		No noAnterior = null;
	
		if (this.noInicial != null) {
			while (noAtual.obterProximo() != null) {
				noAnterior = noAtual;
				noAtual = noAtual.obterProximo();
			}
			if (noAnterior != null) {
				noAnterior.definirProximo(null);
			}
			else {
				this.noInicial = null;
			}
			this.totalDeElementos--;
			return true;
		}
		return false;
	}
	
	@Override
	public boolean excluirMeio(int posicaoExclusao) {
		No noAtual = this.noInicial;
		No noAnterior = null;
		int posicaoAtual = 0;
		
		if (this.noInicial != null) {
			while ((noAtual.obterProximo() != null) && (posicaoExclusao != posicaoAtual)) {
				noAnterior = noAtual;
				noAtual = noAtual.obterProximo();
				posicaoAtual++;
			}
			if (posicaoExclusao == posicaoAtual) {
				if (noAnterior == null) {
					this.noInicial = noAtual.obterProximo();
				}
				else {
					noAnterior.definirProximo(noAtual.obterProximo());
				}
				this.totalDeElementos--;
				return true;
			}
		}
		return false;
	}

	@Override
	public int obterDado(int posicaoBuscada) {
		int posicaoAtual = 0;
		No noAtual = this.noInicial;
		while ((noAtual != null) && (posicaoAtual != posicaoBuscada)){
			noAtual = noAtual.obterProximo();
			posicaoAtual++;
		}
		if (posicaoAtual == posicaoBuscada) {
			return noAtual.obterDado();
		}
		return -1;
	}
	
	@Override
	public int obterTotalDeElementos() {
		return this.totalDeElementos;
	}

	@Override
	public String toString() {
		String elementos = new String();
		No noAtual = this.noInicial;
		while (noAtual != null) {
			elementos = elementos + noAtual.obterDado() + " "; 
			noAtual = noAtual.obterProximo();
		}
		return "ListaEncadeada [ "+ elementos + "]";
	}

	@Override
	public Iterador obterIterador() {
		Iterador iterador = new IteradorListaEncadeada(this.noInicial);
		return iterador;
	}

}