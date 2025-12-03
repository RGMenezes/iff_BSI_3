package lista_encadeada;

public class TesteListaManipulacaoMeio {

	public static void main(String[] args) {
		ListaEncadeadaSimples listaEncadeada = new ListaEncadeadaSimples();
		
		System.out.println("\n------------ Após a inclusão ------------");
		listaEncadeada.adicionarMeio(0, 10);
		listaEncadeada.adicionarMeio(1, 20);
		listaEncadeada.adicionarMeio(2, 30);
		listaEncadeada.adicionarMeio(3, 40);
		listaEncadeada.adicionarMeio(4, 50);
		listaEncadeada.adicionarMeio(5, 60);
		listaEncadeada.adicionarMeio(6, 80);
		System.out.println(listaEncadeada); //O mesmo que: System.out.println(listaEncadeada.toString());
			
		System.out.println("\n\n------------ Após a exclusão do elemento da posição 0 ------------");	
		System.out.println(listaEncadeada.excluirMeio(0));
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Após a exclusão do elemento da posição 5 ------------");	
		System.out.println(listaEncadeada.excluirMeio(5));
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Após a exclusão do elemento da posição 2 ------------");	
		System.out.println(listaEncadeada.excluirMeio(2));
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Após a exclusão do elemto da posição 10 ------------");	
		System.out.println(listaEncadeada.excluirMeio(10));
		System.out.println(listaEncadeada);
	}
}
