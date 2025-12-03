package TP.cs.cs02.view;

import TP.cs.cs02.model.Iterador;
import TP.cs.cs02.model.lista.ListaEncadeada;
import TP.cs.cs02.model.lista.ListaEncadeadaSimples;

public class TesteListaManipulacaoInicio {

	public static void main(String[] args) {
		ListaEncadeada listaEncadeada = new ListaEncadeadaSimples();
		
		listaEncadeada.adicionarInicio(10);
		listaEncadeada.adicionarInicio(20);
		listaEncadeada.adicionarInicio(30);
		listaEncadeada.adicionarInicio(40);
		listaEncadeada.adicionarInicio(50);
		listaEncadeada.adicionarInicio(60);
		listaEncadeada.adicionarInicio(80);
		
		for (int posicao = 0; posicao < 7; posicao++) {
			System.out.println(listaEncadeada.obterDado(posicao));
		}

		System.out.println("\n------------ Após a inclusão ------------");
		System.out.println(listaEncadeada); //O mesmo que: System.out.println(listaEncadeada.toString());	
		
		System.out.println("\n------------ Após a inclusão ------------");
		System.out.println(listaEncadeada.toString());
		
		System.out.println("\n------------ Obtenção do dado da posição 1 (0 é o início)------------");
		System.out.println(listaEncadeada.obterDado(1));
		
		System.out.println("\n\n------------ Após uma exclusão ------------");	
		System.out.println(listaEncadeada.excluirInicio());
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Após mais duas exclusões ------------");	
		System.out.println(listaEncadeada.excluirInicio());
		System.out.println(listaEncadeada.excluirInicio());
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Após mais quatro exclusões ------------");	
		System.out.println(listaEncadeada.excluirInicio());
		System.out.println(listaEncadeada.excluirInicio());
		System.out.println(listaEncadeada.excluirInicio());
		System.out.println(listaEncadeada.excluirInicio());
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Após mais uma exclusão ------------");	
		System.out.println(listaEncadeada.excluirInicio());
		System.out.println(listaEncadeada);
		
		System.out.println("\n------------ Nova inclusão ------------");
		listaEncadeada.adicionarInicio(10);
		listaEncadeada.adicionarInicio(20);
		listaEncadeada.adicionarInicio(30);
		listaEncadeada.adicionarInicio(40);
		listaEncadeada.adicionarInicio(50);
		listaEncadeada.adicionarInicio(60);
		listaEncadeada.adicionarInicio(80);
		System.out.println(listaEncadeada); 
				
		int totalDeElementos = listaEncadeada.obterTotalDeElementos();
		System.out.println("-----------Sem iterador----------------------");		
		for (int posicaoAtual = 0; posicaoAtual < totalDeElementos; posicaoAtual++) {
			System.out.println(listaEncadeada.obterDado(posicaoAtual));
		}
		System.out.println("----------------------------------------------");
		
		System.out.println("\n------------ Listagem com iterador ------------");	
		Iterador iteradorDaLista = listaEncadeada.obterIterador();
		while (iteradorDaLista.temProximo()) {
			System.out.println(iteradorDaLista.obterProximoElemento());
		}
	}
}

		
		
		
		
		
		
		
		
		
		
	
