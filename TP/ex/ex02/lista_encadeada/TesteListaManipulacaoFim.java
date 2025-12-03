package lista_encadeada;

public class TesteListaManipulacaoFim {

	public static void main(String[] args) {
		ListaEncadeadaSimples listaEncadeada = new ListaEncadeadaSimples();
		
		System.out.println("\n------------ Após a inclusão ------------");
		listaEncadeada.adicionarFim(10);
		listaEncadeada.adicionarFim(20);
		listaEncadeada.adicionarFim(30);
		listaEncadeada.adicionarFim(40);
		listaEncadeada.adicionarFim(50);
		listaEncadeada.adicionarFim(60);
		listaEncadeada.adicionarFim(80);
		System.out.println(listaEncadeada); //O mesmo que: System.out.println(listaEncadeada.toString());
			
		System.out.println("\n\n------------ Após uma exclusão ------------");	
		System.out.println(listaEncadeada.excluirFim());
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Após mais duas exclusões ------------");	
		System.out.println(listaEncadeada.excluirFim());
		System.out.println(listaEncadeada.excluirFim());
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Após mais quatro exclusões ------------");	
		System.out.println(listaEncadeada.excluirFim());
		System.out.println(listaEncadeada.excluirFim());
		System.out.println(listaEncadeada.excluirFim());
		System.out.println(listaEncadeada.excluirFim());
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Após mais uma exclusão ------------");	
		System.out.println(listaEncadeada.excluirFim());
		System.out.println(listaEncadeada);
	}
}
