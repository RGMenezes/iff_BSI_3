package lista_encadeada;

public interface ListaEncadeada {
	
	public void adicionarInicio(int dado);
	
	public void adicionarFim(int dado);
	
	public boolean adicionarMeio(int posicaoInclusao, int dado);
	
	public boolean excluirInicio();
	
	public boolean excluirFim();
	
	public boolean excluirMeio(int posicao);
	
	public int obterDado(int posicao);
	
	public int obterTotalDeElementos();
	
	Iterador obterIterador();

	@Override
	public String toString();
}

