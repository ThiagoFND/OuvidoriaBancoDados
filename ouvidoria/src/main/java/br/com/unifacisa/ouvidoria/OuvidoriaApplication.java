package br.com.unifacisa.ouvidoria;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.unifacisa.ouvidoria.entities.Manifestation;
import br.com.unifacisa.ouvidoria.services.Exceptions;
import br.com.unifacisa.ouvidoria.services.PeopleServices;


@SpringBootApplication
public class OuvidoriaApplication implements CommandLineRunner {

	@Autowired
	PeopleServices peopleServices;

	public static void main(String[] args) {
		SpringApplication.run(OuvidoriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Exceptions exc1 = new Exceptions();
		
		Scanner scan = new Scanner(System.in);

		while (true) {

			System.out.println(">>>>>>>>>>>>>>SISTEMA DE CADASTRO DE OCORRENCIAS<<<<<<<<<<<<<<<");
			System.out.println("1 - Cadastro \n2 - Login \n3 - Sair \nDigite: ");
			int input1 = exc1.readWhole();
			
			if (input1 == 1) {
				// register
				
				while (true) {
					System.out.println("1 - Usuário  \n2 - Funcionário \n3 - Voltar \nDigite: ");
					int input2 = exc1.readWhole();
					
					if (input2 == 1) {
						// User
						
						System.out.println("Nome: ");
						String nome = scan.nextLine();

						System.out.println("E-mail: ");
						String email = scan.nextLine();

						System.out.println("Número: ");
						long numero = exc1.readWhole();

						System.out.println("Usuário: ");
						String usuario = scan.nextLine();

						System.out.println("Senha: ");
						String senha = scan.nextLine();
						
						peopleServices.peopleADD(nome, email, numero, usuario, senha);
					} else if (input2 == 2) {
						// Employee
						
						System.out.println("Iniciando cadastro funcionário");

						System.out.println("Nome: ");
						String nome = scan.nextLine();

						System.out.println("E-mail: ");
						String email = scan.nextLine();

						System.out.println("Número: ");
						long numero = exc1.readWhole();

						System.out.println("Usuário: ");
						String usuario = scan.nextLine();

						System.out.println("Senha: ");
						String senha = scan.nextLine();
						
						peopleServices.employeeADD(nome, email, numero, usuario, senha, true);
					} else if (input2 == 3) {
						// Break
						System.out.println("Voltando");
						break;
					} else {
						System.out.println("Número inexistente");
					}
					
				}
			} else if (input1 == 2) {
				// Login
				
				while (true) {
					System.out.println("1 - Usuário \n2 - Funcionário \n3 - Voltar \nDigite: ");
					int input3 = exc1.readWhole();
					
					if (input3 == 1) {
						// User
						System.out.println("Fazer login...\n");
						System.out.println("Usuário: ");
						String usuario = scan.next();
						System.out.println("Senha: ");
						String senha = scan.next();
						
						peopleServices.loginUser(usuario, senha);
						
						if (peopleServices.loginUser(usuario, senha)) {
						    // Login success
							System.out.println("Login efetuado com sucesso usuário");
							
							while (true) {
								// Choose Manifestation Options
								System.out.println("Escolha uma opção:");
								System.out.println(
										"1 - Reclamação \n2 - Elogio \n3 - Sugestão \n4 - Listar todas as reclamações \n5 - Sair \nDigite: ");
								int input4 = exc1.readWhole();
								
								if (input4 == 1) {
									// complaint
									
									while (true) {
										System.out.println("1 - Adicionar reclamação \n2 - Voltar \nDigite: ");
										int input5 = exc1.readWhole();
										
										if (input5 == 1) {
											// add complaint
											
											String type = "Reclamação";
											System.out.println("Tipo: " + type);
											System.out.println("Texto: ");
											String text = scan.nextLine();
											
										} else if (input5 == 2) {
											System.out.println("Voltando");
											break;
										} else {
											System.out.println("Número inexistente");
										}
									}
								} else if (input4 == 2) {
									
								} else if (input4 == 3) {
									
								} else if (input4 == 4) {
									
								} else if (input4 == 5) {
									System.out.println("Voltando");
									break;
								} else {
									System.out.println("Número inexistente");
									break;
								}
							}
						} else {
						    // Login error
						    System.out.println("Usuário ou senha incorretos");
						}

					} else if (input3 == 2) {
						// Employee
						
						System.out.println("Fazer login...\n");
						System.out.println("Usuário: ");
						String usuario = scan.next();
						System.out.println("Senha: ");
						String senha = scan.next();
						
						peopleServices.loginEmployee(usuario, senha);
						
						if (peopleServices.loginEmployee(usuario, senha)) {
						    // Login success
							System.out.println("Login efetuado com sucesso admin");
						} else {
						    // Login error
						    System.out.println("Usuário ou senha incorretos");
						}
					} else if (input3 == 3) {
						// break
						System.out.println("Voltando");
						break;
					} else {
						System.out.println("Número inexistente");
					}
				}
			} else if (input1 == 3) {
				// break
				System.out.println("Saindo");
				break;
			} else {
				System.out.println("Número inexistente");
			}
			
			scan.close();
		}

	}

}
