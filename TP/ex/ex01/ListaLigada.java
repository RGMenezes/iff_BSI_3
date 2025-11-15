public class ListaLigada {
	public static void main(String[] args) {
		ListaEncadeada listaEncadeada = new ListaEncadeada();
		
		System.out.println("\n\n-------Exemplo de Inclus&atilde;o e Exclus&atilde;o no In&iacute;cio da Lista--------");
		for (int indice = 0; indice < 5; indice++) {
			listaEncadeada.incluirInicio(indice);
		}
		listaEncadeada.listarElementos();
		listaEncadeada.excluirInicio();
		System.out.println();
		listaEncadeada.listarElementos();
		for (int indice = 0; indice < 4; indice++) {
			listaEncadeada.excluirInicio();
		}
		System.out.println("\n\n-------Exemplo de Inclus&atilde;o e Exclus&atilde;o no Final da Lista--------");
		for (int indice = 0; indice < 5; indice++) {
			listaEncadeada.incluirFim(indice);
		}
		listaEncadeada.listarElementos();
		listaEncadeada.excluirFim();
		System.out.println();
		listaEncadeada.listarElementos();
		for (int indice = 0; indice < 4; indice++) {
			listaEncadeada.excluirFim();
		}
	}
}

class ListaEncadeada {

	No noInicial = null;

	public void incluirInicio(int dado) {
		No novoNo = new No(dado);
		novoNo.proximo = this.noInicial;
		this.noInicial = novoNo;
	}

	public void excluirInicio() {
		if (this.noInicial != null) {
			this.noInicial = this.noInicial.proximo;
		}
	}
	
	public void incluirFim(int dado) {
		No novoNo = new No(dado);
		if (this.noInicial != null)
		{
			No noAtual = this.noInicial;
			while (noAtual.proximo != null) {
				noAtual = noAtual.proximo;
			}
			noAtual.proximo = novoNo;		
		}
		else {
			this.noInicial = novoNo;
		}
	}

	public void excluirFim() {
		if (this.noInicial != null)
		{
			No noAtual = this.noInicial;
			No noAnterior = null;
			while (noAtual.proximo != null) {
				noAnterior = noAtual;
				noAtual = noAtual.proximo;
			}
			if (noAnterior == null) {
				this.noInicial = null;
			}
			else {
				noAnterior.proximo = null;
			}
		}
	}
	
	public void listarElementos() {
		No noAtual = this.noInicial;
		while (noAtual != null) {
			System.out.print(" " + noAtual.dado);
			noAtual = noAtual.proximo;
		}
	}

	public void incluirIndice(){

	}

}

class No {
	public int dado;
	public No proximo;

	public No(int dado) {
		this.dado = dado;
		this.proximo = null;
	}
}