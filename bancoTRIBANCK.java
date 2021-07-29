/**
 * 
 */
package br.com.patrickfreire.git;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Patrick atividade elaborada no trabalho.
 */
public class caixaEletronico {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		List valor = new ArrayList(0);
		List processo = new ArrayList(0);

		System.out.println("-----------------");
		System.out.println("Bem Vind@ ao banco TRIBANK!!");
		System.out.println("-----------------");

		String cpfDigitado;

		System.out.print("Digte seu CPF: ");
		cpfDigitado = ler.next();
		if (cpfDigitado.equals(cpfDigitado)) {
			System.out.println("CPF Correto");
			System.out.println("Tela de acesso permitido");
			System.out.println("------------------------");
		} else {
			System.out.println("CPF Incorreto");
			System.out.println("Tela de acesso não permitido");
			System.out.println("-----------------------------");
			System.exit(0);

		}

		String senha = "123";
		String senhaDigitada;
		
		
		double deposito = 0, saldoAtual = 0, saque = 0; // double visto em call que suporta valor maior.
		double saldoInicial = 1600;
		int menu = 0;
		double valortransferido = 0;

		System.out.print("Digte sua senha: ");
		senhaDigitada = ler.next();
		int x = 0;

		do {
			if (senha.equals(senhaDigitada)) {
				System.out.println("Senha Correta");
				System.out.println("Tela de acesso permitido");
				System.out.println("-----------------------------");

				do {
					System.out.println("----- MENU -----");
					System.out.println("--- 1 - Saldo ---");
					System.out.println("--- 2 - Depósito ---");
					System.out.println("--- 3 - Saque ---");
					System.out.println("--- 4 - Transferência ---");
					System.out.println("--- 5 - Consultar Extrato ---");
					System.out.println("--- 0 - Sair ---");
					System.out.println("-------------------");

					System.out.print("Escolha um dos números: ");
					menu = ler.nextInt();

					// switch = pega o valor q corresponde no menu.
					switch (menu) {
					case 1:
						saldoAtual = saldoInicial + deposito - saque - valortransferido;
						System.out.println("Seu saldo inical é/era: R$" + saldoInicial);
						System.out.println("Seu saldo atual é de R$" + saldoAtual);
						valor.add(saldoAtual);
						processo.add("Saldo Atual  ");
						System.out.print("Deseja fazer mais alguma operação ? (s/n): ");
						String captcha = ler.next();
						if ("s".equals(captcha)) {
							int menu1 = menu;
						} else if ("n".equals(captcha)) {
							main(args);  // utilizo main para leitura do valor : verificação. 
						}
						break;

					case 2:
						saldoAtual = saldoInicial + deposito - saque - valortransferido;
						System.out.print("Digite o valor que deseja depositar: R$");
						deposito = ler.nextDouble();
						if (deposito < 0) {
							System.out.println("O VALOR DIGITADO R$" + deposito + " É INVÁLIDO!!!");
						} else {
							saldoAtual = saldoAtual + deposito;
							System.out.println("R$" + deposito + " Depositado com sucesso");
							System.out.println("Seu saldo é de R$" + saldoAtual);
							valor.add(deposito);
							processo.add("Deposito     ");
						}
						System.out.print("Deseja fazer mais alguma operação ? (s/n): ");
						String captcha1 = ler.next();
						if ("s".equals(captcha1)) {
							int menu1 = menu;
						} else if ("n".equals(captcha1)) {
							main(args);
						}
						break;

					case 3:
						saldoAtual = saldoInicial + deposito - saque - valortransferido;
						System.out.print("Digite o valor que deseja sacar: R$");
						saque = ler.nextDouble();
						if (saque < 0) {
							System.out.println("O VALOR DIGITADO R$" + saque + " É INVÁLIDO!!!");
						} else if (saque > saldoAtual) {
							System.out.println("SALDO INSUFISIENTE!!!");
						} else {
							saldoAtual = saldoAtual - saque;
							System.out.println("R$" + saque + " Sacado com sucesso");
							System.out.println("Seu saldo é de R$" + saldoAtual);
							valor.add(saque);
							processo.add("Saque        ");
						}
						System.out.print("Deseja fazer mais alguma operação ? (s/n): ");
						String captcha2 = ler.next();
						if ("s".equals(captcha2)) {
							int menu1 = menu;
						} else if ("n".equals(captcha2)) {
							main(args);
						}
						break;

					case 4:
						saldoAtual = saldoInicial + deposito - saque - valortransferido;
						System.out.print("Digite o nome do banco para qual deseja fazer a transfêrencia: ");
						String banco = ler.next();
						System.out.print(
								"Digite o número da agência do banco para qual deseja fazer a transfêrencia (Digitar apenas números): ");
						System.out.print(
								"Digite o número da conta do usuario para qual deseja fazer a transfêrencia (Digitar apenas números): ");
						System.out.print("Digite o valor a ser tranferido? R$");
						valortranf = ler.nextDouble();
						if (valortranf < 0) {
							System.out.println("O VALOR DIGITADO R$" + valortransferido + " É INVÁLIDO!!!");
						} else if (valortranf > saldoAtual) {
							System.out.println("SALDO INSUFISIENTE!!!");
						} else {
							saldoAtual = saldoAtual - valortransferido;
							System.out.println("R$" + valortransferido + " Tranferido com sucesso");
							System.out.println("Seu saldo é de R$" + saldoAtual);
							valor.add(valortransferido);
							processo.add("Tranfêrencia ");
						}
						System.out.print("Deseja fazer mais alguma operação ? (s/n): ");
						String captcha3 = ler.next();
						if ("s".equals(captcha3)) {
						} else if ("n".equals(captcha3)) {
							main(args);
						}
						break;

					case 5:
						System.out.println("------ Extrato ------");
						System.out.println("Processo              Valor");
						System.out.println("Saldo inicial         " + saldoInicial);
						for (int i = 0; i < valor.size(); i++) {
							System.out.println(processo.get(i) + "         R$" + valor.get(i));
						}
						System.out.println("---------------------");
						System.out.print("Deseja fazer mais alguma operação ? (s/n): ");
						String captcha4 = ler.next();
						if ("s".equals(captcha4)) {
						} else if ("n".equals(captcha4)) {
							main(args);
						}
						break;

					case 0:
						System.out.println("Você saiu do menu");
						main(args);
						break;

					default:
						System.out.println("VOCÊ DIGITOU NÚMERO INVÁLIDO!!");
						break;
					}
				} while (menu != 0);

			}

			if (senha.equals(senhaDigitada)) {
				System.out.println("Senha Correta");
				System.out.println("Tela de acesso permitido");
				System.out.println("-----------------------------");

				int menu2 = menu;
			} else {
				System.out.println("Senha Incoreta");
				System.out.println("--------------");
				System.out.print("Digte novamente a sua senha: ");
				senhaDigitada = ler.next();
			}
			x++;

		} while (x < 2);
		System.out.println("Você digitou 3 vezes a senha errada!!!");
		System.out.println("Máximo de tentativas");
		System.out.println("Sua conta foi Bloqueada");
		main(args);

	}

}
