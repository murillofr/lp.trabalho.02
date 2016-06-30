package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Trabalho03 {
	
	/**
	 * Faz a leitura dos vetores JÁ INSTANCIADOS a partir da entrada padrao
	 * @param cod Vetor CÓDIGO
	 * @param desc Vetor DESCRIÇÃO
	 * @param preco Vetor PREÇO
	 * @param qtd Vetor QUANTIDADE
	 */
	public static void lerVet (int[] cod, String[] desc, double[] preco, int[] qtd){
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<cod.length;i++){
			System.out.println("╔────────────────────────────────────────────────────────╗");
			System.out.printf("│                       %-11s                      │\n", ("PRODUTO " + (i+1)));
			System.out.println("╠────────────────────────────────────────────────────────╣");
			System.out.print(" CÓDIGO:     ");
			cod[i] = sc.nextInt();
			System.out.print(" DESCRIÇÃO:  ");
			desc[i] = sc.nextLine();
			desc[i] = sc.nextLine();
			System.out.print(" PREÇO:      ");
			preco[i] = sc.nextDouble();
			System.out.print(" QUANTIDADE: ");
			qtd[i] = sc.nextInt();
			System.out.println("╚────────────────────────────────────────────────────────╝");
			System.out.println();
		
//		for(int i=0;i<cod.length;i++){			
//			System.out.println(">>PRODUTO " + (i+1) + "<<");
//			System.out.print("CÓDIGO:     ");
//			cod[i] = sc.nextInt();
//			System.out.print("DESCRIÇÃO:  ");
//			desc[i] = sc.nextLine();
//			desc[i] = sc.nextLine();
//			System.out.print("PREÇO:      ");
//			preco[i] = sc.nextDouble();
//			System.out.print("QUANTIDADE: ");
//			qtd[i] = sc.nextInt();
//			System.out.println();
		}
	}
	
	/**
	 * Mostra na tela as opções para escolha do usuário
	 */
	public static void mostrarOpcoes () {
	    System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
	    System.out.println("║                         DIGITE UMA DAS OPÇÕES ABAIXO:                         ║");
	    System.out.println("║ 1 – Imprimir tabela                                                           ║");
	    System.out.println("║ 2 – Pesquisar produto                                                         ║");
	    System.out.println("║ 3 – Mostrar dados do produto mais caro                                        ║");
	    System.out.println("║ 4 – Mostrar código e descrição dos produtos cuja quantidade está abaixo de 10 ║");
	    System.out.println("║ 5 – Ativo total do estoque                                                    ║");
	    System.out.println("║ 6 – Efetuar uma venda                                                         ║");
	    System.out.println("║ 7 – Sair                                                                      ║");
	    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
	}
	
	/**
	 * Mostra na tela os vetores JÁ PREENCHIDOS
	 * @param cod Vetor CÓDIGO
	 * @param desc Vetor DESCRIÇÃO
	 * @param preco Vetor PREÇO
	 * @param qtd Vetor QUANTIDADE
	 */
	public static void mostrarTabela(int[] cod, String[] desc, double[] preco, int[] qtd){
		System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
	    System.out.println("║                               TABELA DE PRODUTOS                              ║");
	    System.out.println("╠════════╦═══════════════════════════════════════════╦═════════════╦════════════╣");
		System.out.println("║ CÓDIGO ║                 DESCRIÇÃO                 ║    PREÇO    ║ QUANTIDADE ║");
		System.out.println("╠════════╬═══════════════════════════════════════════╬═════════════╬════════════╣");	    
		for(int i=0;i<cod.length;i++){
			System.out.printf("║ %-6d ║ %-41s ║ R$ %8.2f ║ %10d ║\n", cod[i], desc[i], preco[i], qtd[i]);
			if ((i+1)<cod.length) {
				System.out.println("╠────────╬───────────────────────────────────────────╬─────────────╬────────────╣");
			} else {
				System.out.println("╚════════╩═══════════════════════════════════════════╩═════════════╩════════════╝");
			}
		}
	}
	
	/**
	 * Pesquisa um código digitado pelo usuário mostrando na tela suas informações e valor total em estoque
	 * @param cod Vetor CÓDIGO
	 * @param desc Vetor DESCRIÇÃO
	 * @param preco Vetor PREÇO
	 * @param qtd Vetor QUANTIDADE
	 */
	public static void pesquisarProduto(int[] cod, String[] desc, double[] preco, int[] qtd){
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite um código de produto a ser pesquisado: ");
		int codPesq = sc.nextInt();
		int contador = 0;
		for (int i=0; i<cod.length; i++) {
			if (cod[i] == codPesq) {
				contador = 1;
				double vlrTotal = preco[i] * qtd[i];
				System.out.println("╔════════╦═══════════════════════════════════════════╦═════════════╦════════════╦════════════════════════╗");
				System.out.println("║ CÓDIGO ║                 DESCRIÇÃO                 ║    PREÇO    ║ QUANTIDADE ║ VALOR TOTAL EM ESTOQUE ║");
				System.out.println("╠════════╬═══════════════════════════════════════════╬═════════════╬════════════╬════════════════════════╣");
				System.out.printf("║ %-6d ║ %-41s ║ R$ %8.2f ║ %10d ║ R$ %19.2f ║\n", cod[i], desc[i], preco[i], qtd[i], vlrTotal);
				System.out.println("╚════════╩═══════════════════════════════════════════╩═════════════╩════════════╩════════════════════════╝");
			}
		}
		if (contador == 0) {
			System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
		    System.out.println("║                          ERRO, PRODUTO NÃO ENCONTRADO                         ║");
		    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
		}
	}
	
	/**
	 * Mostra na tela as informações do produto mais caro
	 * @param cod Vetor CÓDIGO
	 * @param desc Vetor DESCRIÇÃO
	 * @param preco Vetor PREÇO
	 * @param qtd Vetor QUANTIDADE
	 */
	public static void produtoMaisCaro(int[] cod, String[] desc, double[] preco, int[] qtd){
		int posicao = 0;
		double precoZero = 0.0;
		for(int i=0;i<cod.length;i++){
			if (i == 0) {
				posicao = i;
				precoZero = preco[i];
			}else if (preco[i] > precoZero) {
				posicao = i;
				precoZero = preco[i];
			}
		}
		System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
	    System.out.println("║                               PRODUTO MAIS CARO                               ║");
	    System.out.println("╠════════╦═══════════════════════════════════════════╦═════════════╦════════════╣");
		System.out.println("║ CÓDIGO ║                 DESCRIÇÃO                 ║    PREÇO    ║ QUANTIDADE ║");
		System.out.println("╠════════╬═══════════════════════════════════════════╬═════════════╬════════════╣");
			System.out.printf("║ %-6d ║ %-41s ║ R$ %8.2f ║ %10d ║\n", cod[posicao], desc[posicao], preco[posicao], qtd[posicao]);
				System.out.println("╚════════╩═══════════════════════════════════════════╩═════════════╩════════════╝");		
	}
	
	/**
	 * Mostra na tela os códigos e descrições dos produtos cujas quantidades estão abaixo de 10
	 * @param cod Vetor CÓDIGO
	 * @param desc Vetor DESCRIÇÃO
	 * @param preco Vetor PREÇO
	 * @param qtd Vetor QUANTIDADE
	 */
	public static void produtosAbaixo10(int[] cod, String[] desc, int[] qtd){
		int qtdProdutos = 0;
		int ultimoBaixo = 0;
		for(int i=0;i<cod.length;i++){
			if (qtd[i] < 10) {
				qtdProdutos = qtdProdutos + 1;
			}
		}
		if (qtdProdutos > 0) {
			System.out.println("╔════════════════════════════════════════════════════╗");
		    System.out.println("║            PRODUTO(S) COM ESTOQUE BAIXO            ║");
		    System.out.println("╠════════╦═══════════════════════════════════════════╣");
			System.out.println("║ CÓDIGO ║                 DESCRIÇÃO                 ║");
			System.out.println("╠════════╬═══════════════════════════════════════════╣");	    
			for(int j=0;j<cod.length;j++){
				if (qtd[j] < 10) {
					ultimoBaixo = j;
				}
			}
			for(int j=0;j<cod.length;j++){
				if (qtd[j] < 10) {
						System.out.printf("║ %-6d ║ %-41s ║\n", cod[j], desc[j]);
						if (j<ultimoBaixo) {
							System.out.println("╠────────╬───────────────────────────────────────────╣");
						} else {
							System.out.println("╚════════╩═══════════════════════════════════════════╝");
						}						
				}
			}
		}else {
			System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
		    System.out.println("║                     NÃO EXISTEM PRODUTOS COM ESTOQUE BAIXO                    ║");
		    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");			
		}
		
	}	
	
	/**
	 * Calcula e exibe na tela a soma geral do valor total no estoque (preço x qte) de todos os produtos
	 * @param preco Vetor PREÇO
	 * @param qtd Vetor QUANTIDADE
	 */
	public static void ativoTotal(double[] preco, int[] qtd){
		double ativoTotal = 0.0;
		for (int i=0; i<preco.length; i++) {
			ativoTotal = ativoTotal + (preco[i] * qtd[i]);
		}
		System.out.println("╔════════════════════════╗");
		System.out.println("║ ATIVO TOTAL DO ESTOQUE ║");
		System.out.println("╠════════════════════════╣");
		System.out.printf("║ R$ %19.2f ║\n", ativoTotal);
		System.out.println("╚════════════════════════╝");
	}
	
	/**
	 * Efetua uma venda.
	 * O usuário informa um código de produto.
	 * Se o produto não existir, exibe uma mensagem de erro. Caso contrário, o usuário informa a quantidade a ser vendida.
	 * Se a quantidade do produto for insuficiente, exibe uma mensagem de erro.
	 * Caso contrário, abate a quantidade vendida no registro do produto na tabela e mostra uma mensagem de sucesso.
	 * @param cod Vetor CÓDIGO
	 * @param desc Vetor DESCRIÇÃO
	 * @param preco Vetor PREÇO
	 * @param qtd Vetor QUANTIDADE
	 */
	public static void venda(int[] cod, String[] desc, double[] preco, int[] qtd){
		Scanner sc = new Scanner(System.in);
		System.out.print("Digite o código do produto a ser vendido: ");
		int codPesq = sc.nextInt();
		int contador = 0;
		for (int i=0; i<cod.length; i++) {
			if (cod[i] == codPesq) {
				contador = 1;
				System.out.print("Digite a quantidade a ser vendida: ");
				int qtdVendida = sc.nextInt();
				
				if (qtdVendida <= qtd[i]) {
					contador = 2;
					qtd[i] = qtd[i] - qtdVendida;
					System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
				    System.out.println("║                           VENDA EFETUADA COM SUCESSO                          ║");
				    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
				}
			}
		}
		if (contador == 0) {
			System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
		    System.out.println("║                          ERRO, PRODUTO NÃO ENCONTRADO                         ║");
		    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
		}else if (contador == 1) {
			System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
		    System.out.println("║           ERRO, QUANTIDADE A SER VENDIDA É MAIOR DO QUE A EM ESTOQUE          ║");
		    System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");
		}
	}	
	
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	sc.useLocale(Locale.ENGLISH);
	Locale.setDefault(new Locale("en", "US"));
	
	int N, menu;
	
	System.out.print("QUANTOS PRODUTOS SERÃO INSERIDOS? ");
	N = sc.nextInt();
	System.out.println("\n=================================================================================\n");
	int cod[] = new int[N];
	String desc[] = new String[N];
	double preco[] = new double[N];
	int qtd[] = new int[N];
	
    lerVet(cod, desc, preco, qtd);
    
    System.out.println("=================================================================================\n");
    
    mostrarOpcoes();
    
    System.out.print("Opção: ");
	menu = sc.nextInt();
	System.out.println("\n=================================================================================\n");
	
	while (menu != 7) {
		switch ( menu ) {
		    case 1:
		    	mostrarTabela(cod, desc, preco, qtd);
		    	
		        System.out.println("\n=================================================================================\n");
		        
		        mostrarOpcoes();
		        
		        System.out.print("Opção: ");
		    	menu = sc.nextInt();
		    	System.out.println("\n=================================================================================\n");
		    	
		    	break;
		    	
		    case 2:
		    	pesquisarProduto(cod, desc, preco, qtd);
		    	
		        System.out.println("\n=================================================================================\n");
		        
		        mostrarOpcoes();
		        
		        System.out.print("Opção: ");
		    	menu = sc.nextInt();
		    	System.out.println("\n=================================================================================\n");		    	
		    	
		    	break;
		    	
		    case 3:
		    	produtoMaisCaro(cod, desc, preco, qtd);
		    	
		        System.out.println("\n=================================================================================\n");
		        
		        mostrarOpcoes();
		        
		        System.out.print("Opção: ");
		    	menu = sc.nextInt();
		    	System.out.println("\n=================================================================================\n");		    	
		    	
		    	break;
		    	
		    case 4:
		    	produtosAbaixo10(cod, desc, qtd);
		    	
		        System.out.println("\n=================================================================================\n");
		        
		        mostrarOpcoes();
		        
		        System.out.print("Opção: ");
		    	menu = sc.nextInt();
		    	System.out.println("\n=================================================================================\n");		    	
		    	
		    	break;
		    	
		    case 5:
		    	ativoTotal(preco, qtd);
		    	
		        System.out.println("\n=================================================================================\n");
		        
		        mostrarOpcoes();
		        
		        System.out.print("Opção: ");
		    	menu = sc.nextInt();
		    	System.out.println("\n=================================================================================\n");		    	
		    	
		    	break;
		    	
		    case 6:
		    	venda(cod, desc, preco, qtd);
		    	
		        System.out.println("\n=================================================================================\n");
		        
		        mostrarOpcoes();
		        
		        System.out.print("Opção: ");
		    	menu = sc.nextInt();
		    	System.out.println("\n=================================================================================\n");
		    	break;
		    	
		    default:
		    	System.out.println("╔═══════════════════════════════════════════════════════════════════════════════╗");
		        System.out.println("║                        OPÇÃO INCORRETA, TENTE NOVAMENTE                       ║");
		        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════╝");		    	
		        System.out.println("\n=================================================================================\n");
		        
		        mostrarOpcoes();
		        
		        System.out.print("Opção: ");
		    	menu = sc.nextInt();
		    	System.out.println("\n=================================================================================\n");
		    	break;
		}
	}
	System.err.println("APLICAÇÃO ENCERRADA COM SUCESSO");	
	
	sc.close();
	}

}