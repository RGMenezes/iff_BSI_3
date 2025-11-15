package TP.cs.cs01;

import java.util.Scanner;

//=================================================
//	Exercício 01
//
//	Adicionar funcionalidades na implementação de 
//	lista encadeada disponibilizada.
//-------------------------------------------------
//  * Incluir elemento em uma posição específica da 
//    estrutura.
//  Obs: Levar em consideração que a estrutura
//  começa na posição 0.
//
//  * Excluir um nó que possua um determinado dado.
//=================================================

public class ListaLigada {
	public static void main(String[] args) {
		ListaEncadeada listaEncadeada = new ListaEncadeada();
        @SuppressWarnings("resource")
        Scanner entrada = new Scanner(System.in);
        int option = 0;
		do {
            System.out.println("""
            
            Lista Ligada:
                1 - Inserir (Início)
                2 - Inserir (Índice)
                3 - Inserir (Fim)
                4 - Excluir (Início)
                5 - Excluir (Valor)
                6 - Excluir (Fim)
                7 - Preencher (Testes)
                0 - Sair

            Lista atual: 
                %s

            """.formatted(listaEncadeada.listarElementos()));
            System.out.print("Escolha:  ");
            option = entrada.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Saindo...");
                    break;

                case 1:
                    System.out.print("Valor: ");
                    listaEncadeada.incluirInicio(entrada.nextInt());
                    break;

                case 2:
                    System.out.print("Valor: ");
                    int dado = entrada.nextInt();
                    System.out.print("Posição: ");
                    int indice = entrada.nextInt();

                    try {
                        listaEncadeada.incluirComIndice(dado, indice);
                    } catch (IndexOutOfBoundsException erro) {
                        System.out.println(erro);
                    }

                    break;

                case 3:
                    System.out.print("Valor: ");
                    listaEncadeada.incluirFim(entrada.nextInt());
                    break;
                    
                case 4:
                    listaEncadeada.excluirInicio();
                    break;
                    
                case 5:
                    System.out.print("Valor: ");
                    try {
                        listaEncadeada.excluirDado(entrada.nextInt());
                    } catch (IllegalArgumentException erro) {
                        System.out.println(erro);
                    } catch (IllegalStateException erro) {
                        System.out.println(erro);
                    }   
                    break;

                case 6:
                    listaEncadeada.excluirFim();
                    break;
                
                case 7:
                    System.out.print("Quantidade: ");
                    int valorMaximo = entrada.nextInt();
                    for (int i = valorMaximo; i > 0; i--) {
                        listaEncadeada.incluirInicio(i);
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
        } while (option != 0);
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

    public void incluirComIndice(int dado, int indice){
        if((this.noInicial == null && indice != 0) || indice < 0) throw new IndexOutOfBoundsException("Posição não existe no array!");
        
        No novoNo = new No(dado);

        if(indice == 0){
            novoNo.proximo = this.noInicial;
		    this.noInicial = novoNo;
            return;
        }

        No noAtual = this.noInicial;
        int contador = 1;

        while(contador != indice && noAtual.proximo != null){
            noAtual = noAtual.proximo;
            contador++;
        }

        if(contador == indice){
            novoNo.proximo = noAtual.proximo;
            noAtual.proximo = novoNo;
            return;
        }
        
        throw new IndexOutOfBoundsException("Posição não existe no array!");
	}

    public void excluirDado(int dado){
        if(this.noInicial == null) throw new IllegalStateException("Não é possível excluir: a lista está vazia.");
    
        if(this.noInicial.dado == dado){
            this.noInicial = this.noInicial.proximo;
            return;
        }

        No noAnterior = this.noInicial;
        No noAtual = this.noInicial.proximo;

        while (noAtual != null && noAtual.dado != dado) {
            noAnterior = noAtual;
            noAtual = noAtual.proximo;
        }
        
        if(noAtual == null) throw new IllegalArgumentException("Elemento não encontrado!");

        noAnterior.proximo = noAtual.proximo;
    }
	
	public String listarElementos() {
		No noAtual = this.noInicial;
        String messagem = "[";
		while (noAtual != null) {
			messagem += " " + noAtual.dado;
			noAtual = noAtual.proximo;
		}
        return messagem + " ]";
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