package lista_encadeada;

public class No {
	private int dado;
	private No proximo;
	
	public No(int dado) {
		this.dado =  dado;
		this.proximo = null;
	}

	public int obterDado() {
		return this.dado;
	}

	public void definirDado(int dado) {
		this.dado = dado;
	}

	public No obterProximo() {
		return this.proximo;
	}

	public void definirProximo(No proximo) {
		this.proximo = proximo;
	}
	
}
