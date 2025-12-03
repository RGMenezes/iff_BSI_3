package lista_encadeada;

public class IteradorListaEncadeada implements Iterador{

	No noAtual; 
	
	public IteradorListaEncadeada(No no) {
		this.noAtual = no;
	}
	
	public boolean temProximo() {
		if (this.noAtual != null) {
			return true;
		}
		return false;
	}
	
	public int obterProximoElemento() {
		int dado = this.noAtual.obterDado();
		this.noAtual = this.noAtual.obterProximo();
		return dado;
	}
}
