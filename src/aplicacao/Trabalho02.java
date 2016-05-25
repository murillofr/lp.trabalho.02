package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class Trabalho02 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		String vet_nome[], vet_tel[];
		int N, i, vet_tipo[], vet_min[], menor_conta, qtd_cli_tip1, soma_min_tip1, qtd_cli_menos_91min, qtd_cli_mais_120min, qtd_cli_tip2;
		double vet_valor_conta[], mat_ass[][], receita_total, media_min_tip1, porc_cli_tip2;

		System.out.println("========================================================================");
		System.out.println();
		System.out.print("QUANTOS CLIENTES VOCÊ IRÁ DIGITAR? ");
		N = sc.nextInt();
		
		System.out.println();
		System.out.println("========================================================================");
		System.out.println();
		
		if (N != 0) {
		
			vet_nome = new String[N];
			vet_tel = new String[N];
			vet_tipo = new int[N];
			vet_min = new int[N];
			vet_valor_conta = new double[N];
			mat_ass = new double[3][2];
			
			//Leitura dos dados dos clientes
			for (i = 0; i < N; i++) {
				
				System.out.println("CLIENTE " + (i+1));
				
				System.out.print("NOME:     ");
				vet_nome[i] = sc.nextLine();
				vet_nome[i] = sc.nextLine();
				
				System.out.print("TELEFONE: ");
				vet_tel[i] = sc.nextLine();
				
				System.out.print("TIPO:     ");
				vet_tipo[i] = sc.nextInt();
	
				System.out.print("MINUTOS:  ");
				vet_min[i] = sc.nextInt();
				
				System.out.println();
				
			}
			
			System.out.println("========================================================================");
			System.out.println();
			
			//Leitura dos tipos de assinaturas, seus valores e minutos excedentes
			for (i = 0; i <= 2; i++) {
				
				System.out.println("ASSINATURA TIPO " + i);
				
				System.out.print("PREÇO BÁSICO:     R$ ");
				mat_ass[i][0] = sc.nextDouble();
	
				System.out.print("MINUTO EXCEDENTE: R$ ");
				mat_ass[i][1] = sc.nextDouble();
				
				System.out.println();
				
			}
			
			System.out.println("========================================================================");
			System.out.println();
			
			//Cálculo do valor total da conta de cada cliente
			for (i = 0; i < N; i++) {
				
				if (vet_min[i] <= 90) {
					
					switch (vet_tipo[i]) {
					case 0:
						vet_valor_conta[i] = mat_ass[0][0];
						break;
					case 1:
						vet_valor_conta[i] = mat_ass[1][0];
						break;
					case 2:
						vet_valor_conta[i] = mat_ass[2][0];
						break;
					}
					
				}else {
					
					switch (vet_tipo[i]) {
					case 0:
						vet_valor_conta[i] = mat_ass[0][0] + ((vet_min[i] - 90) * mat_ass[0][1]);
						break;
					case 1:
						vet_valor_conta[i] = mat_ass[1][0] + ((vet_min[i] - 90) * mat_ass[1][1]);
						break;
					case 2:
						vet_valor_conta[i] = mat_ass[2][0] + ((vet_min[i] - 90) * mat_ass[2][1]);
						break;
					}
					
				}
				
			}
			
			//Exibição da tabela com todos os dados dos clientes
			System.out.println("------------------------------------------------------------------------");
			System.out.println("|      NOME       |  TELEFONE   | TIPO ASS. | MINUTOS | VALOR DA CONTA |");
			for (i = 0; i < N; i++) {
				
				System.out.printf("| %-15s | ", vet_nome[i]);
				System.out.printf(" %-10s | ", vet_tel[i]);
				System.out.printf("%5d     | ", vet_tipo[i]);
				System.out.printf("%7d | ", vet_min[i]);
				System.out.printf("R$ %11.2f |\n", vet_valor_conta[i]);
				
			}
			
			System.out.println("------------------------------------------------------------------------");
			System.out.println();
			System.out.println("========================================================================");
			System.out.println();
			
			//Cálculo da Receita Total (Soma de todas as contas)
			receita_total = 0.0;
			for (i = 0; i < N; i++) {
				
				receita_total = receita_total + vet_valor_conta[i];
				
			}
			System.out.printf("1) RECEITA TOTAL: R$ %.2f\n", receita_total);
			
			System.out.println();
			
			//Cálculo para descobrir o cliente com a conta mais barata
			menor_conta = 0;
			for (i = 0; i < N; i++) {
				
				if (i == 0) {
					
					menor_conta = i;
					
				}else {
				
					if ( vet_valor_conta[i] < vet_valor_conta[menor_conta]) {
						
						menor_conta = i;
						
					}
				
				}
				
			}
			System.out.printf("2) CONTA MAIS BARATA: %s | %s\n", vet_nome[menor_conta], vet_tel[menor_conta]);
			System.out.println();
			
			//Cálculo da média de minutos consumidos pelos clientes de conta tipo 1
			qtd_cli_tip1 = 0;
			soma_min_tip1 = 0;
			media_min_tip1 = 0.0;
			for (i = 0; i < N; i++) {
				
				if (vet_tipo[i] == 1) {
					
					qtd_cli_tip1 = qtd_cli_tip1 + 1;
					soma_min_tip1 = soma_min_tip1 + vet_min[i];
					
				}
				
			}
			media_min_tip1 = (double) soma_min_tip1 / (double) qtd_cli_tip1;
			System.out.printf("3) MÉDIA MIN. CONSU. CLIENTES TIPO 1: %.2f\n", media_min_tip1);
			System.out.println();
			
			//Cálculo para descobrir nome e telefone dos clientes que não tiveram minutos excedentes
			System.out.println("4) CLIENTES QUE NÃO EXCEDERAM SUA FRANQUIA (90MIN):");
			qtd_cli_menos_91min = 0;
			for (i = 0; i < N; i++) {
				
				if (vet_min[i] <= 90) {
					
					qtd_cli_menos_91min = qtd_cli_menos_91min + 1;
					
				}
				
			}
			
			if (qtd_cli_menos_91min != 0) {
				
				System.out.println("         ---------------------------------");
				System.out.println("         |      NOME       |  TELEFONE   |");
				
				for (i = 0; i < N; i++) {
					
					if (vet_min[i] <= 90) {
						
						System.out.printf("         | %-15s |", vet_nome[i]);
						System.out.printf("  %-10s |\n", vet_tel[i]);
						
					}
					
				}
				System.out.println("         ---------------------------------\n");
				
			}else {
				
				System.out.println("         *** NENHUM CLIENTE ENCONTRADO ***\n");
				
			}
			
			//Cálculo da quantidade de clientes que consumiram acima de 120min.
			qtd_cli_mais_120min = 0;
			for (i = 0; i < N; i++) {
				
				if (vet_min[i] > 120) {
					
					qtd_cli_mais_120min = qtd_cli_mais_120min + 1;
					
				}
				
			}
			System.out.println("5) QTD CLIENTES CONSU. MAIS QUE 120MIN: " + qtd_cli_mais_120min + "\n");
			
			//Cálculo da porcentagem de clientes que possuem conta tipo 2
			porc_cli_tip2 = 0.0;
			qtd_cli_tip2 = 0;
			for (i = 0; i < N; i++) {
				
				if (vet_tipo[i] == 2) {
					
					qtd_cli_tip2 = qtd_cli_tip2 + 1;
					
				}
				
			}
			porc_cli_tip2 = (double) qtd_cli_tip2 * 100.00 / (double) N;
			System.out.printf("6) PORCENTAGEM DE CLIENTES TIPO 2: %.2f%%\n", porc_cli_tip2);
			
			System.out.println();
			System.out.print("========================================================================");
			
		}
		
		sc.close();
	}
}