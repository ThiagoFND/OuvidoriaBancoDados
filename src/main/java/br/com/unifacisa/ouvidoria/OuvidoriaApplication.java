package br.com.unifacisa.ouvidoria;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.unifacisa.ouvidoria.entities.Manifestation;
import br.com.unifacisa.ouvidoria.services.Exceptions;
import br.com.unifacisa.ouvidoria.services.PeopleServices;

/*
 * this ombudsman system is composed of user and employee registration and login. 
 * The user has access to register and list manifestations, among them are: Complaints, 
 * compliments and suggestions. Employee has access to remove user manifestation when complete and list. 
 * The registration system is also added to the database as well as the manifestations, 
 * all using spring boot to add to the Workbench through mysql
 */
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

		int enterWhile = 0;
		while (enterWhile != 3) {

			System.out.println("<- ombudsman system ->");
			System.out.println("1 - Register \n2 - Login \n3 - Leaving \nInput: ");
			int input1 = exc1.readWhole();

			if (input1 == 1) {
				// register

				int enterWhile1 = 0;
				while (enterWhile1 != 3) {
					System.out.println("1 - User  \n2 - Employe \n3 - Returning \nInput: ");
					int input2 = exc1.readWhole();

					if (input2 == 1) {
						// User

						System.out.println("Starting user registration");
						
						System.out.println("Name: ");
						String name = exc1.read();

						System.out.println("E-mail: ");
						String email = exc1.read();

						System.out.println("Number: ");
						long number = exc1.readWhole();

						System.out.println("User: ");
						String user = exc1.read();

						System.out.println("Password: ");
						String password = exc1.read();

						peopleServices.peopleADD(name, email, number, user, password);
					} else if (input2 == 2) {
						// Employee

						System.out.println("Starting Employe registration");

						System.out.println("Name: ");
						String name = exc1.read();

						System.out.println("E-mail: ");
						String email = exc1.read();

						System.out.println("Number: ");
						long number = exc1.readWhole();

						System.out.println("User: ");
						String user = exc1.read();

						System.out.println("Password: ");
						String password = exc1.read();

						peopleServices.employeeADD(name, email, number, user, password, true);
					} else if (input2 == 3) {
						// Break
						System.out.println("returning");
						break;
					} else {
						System.out.println("non-existent number");
					}

				}
			} else if (input1 == 2) {
				// Login

				int enterWhile2 = 0;
				while (enterWhile2 != 3) {
					System.out.println("1 - User \n2 - Employe \n3 - Return \nInput: ");
					int input3 = exc1.readWhole();

					if (input3 == 1) {
						// User
						System.out.println("Login...\n");
						System.out.println("User: ");
						String user = exc1.read();
						System.out.println("Password: ");
						String password = exc1.read();

						peopleServices.loginUser(user, password);

						if (peopleServices.loginUser(user, password) != null) {
							// Login success
							System.out.println("successful login");

							int enterWhile4 = 0;
							while (enterWhile4 != 5) {
								// Choose Manifestation Options
								System.out.println(
										"1 - Complaint \n2 - Praise \n3 - Suggestion \n4 - list all manifestations \n5 - Leaving \nInput: ");
								int input4 = exc1.readWhole();

								if (input4 == 1) {
									// complaint

									int enterWhile5 = 0;
									while (enterWhile5 != 2) {
										System.out.println("1 - add complaint \n2 - Returning \nInput: ");
										int input5 = exc1.readWhole();

										if (input5 == 1) {
											// add complaint

											String type = "complaint";
											System.out.println("Type: " + type);
											System.out.println("Text: ");
											String text = exc1.read();

											peopleServices.addManifestation(type, text,
													peopleServices.loginUser(user, password));

										} else if (input5 == 2) {
											System.out.println("returning");
											break;
										} else {
											System.out.println("non-existent number");
										}
									}
								} else if (input4 == 2) {
									// praise

									int enterWhile5 = 0;
									while (enterWhile5 != 2) {
										System.out.println("1 - Add praise \n2 - Returning \nInput: ");
										int input5 = exc1.readWhole();

										if (input5 == 1) {
											// add praise

											String type = "praise";
											System.out.println("Type: " + type);
											System.out.println("Text: ");
											String text = exc1.read();

											peopleServices.addManifestation(type, text,
													peopleServices.loginUser(user, password));

										} else if (input5 == 2) {
											System.out.println("returning");
											break;
										} else {
											System.out.println("non-existent number");
										}
									}

								} else if (input4 == 3) {
									// Suggestion

									int enterWhile5 = 0;
									while (enterWhile5 != 2) {
										System.out.println("1 - Add Suggestion \n2 - Returning \nDInput: ");
										int input5 = exc1.readWhole();

										if (input5 == 1) {
											// add praise

											String type = "Suggestion";
											System.out.println("Type: " + type);
											System.out.println("Text: ");
											String text = exc1.read();

											peopleServices.addManifestation(type, text,
													peopleServices.loginUser(user, password));

										} else if (input5 == 2) {
											System.out.println("returning");
											break;
										} else {
											System.out.println("non-existent number");
										}
									}
								} else if (input4 == 4) {
									String type = "";
									String text = "";
									peopleServices.ListManifestation(type, text);
								} else if (input4 == 5){
									System.out.println("returning");
									break;
								} else {
									System.out.println("non-existent number");
									break;
								}
							}
						} else {
							// Login error
							System.out.println("incorrect username or password");
						}

					} else if (input3 == 2) {
						// Employee

						System.out.println("User: ");
						String usuario = exc1.read();
						System.out.println("Password: ");
						String password = exc1.read();
						if (peopleServices.loginAdmin(usuario, password) != null) {
							System.out.println("successful login");

							int enterWhile7 = 0;
							while (enterWhile7 != 3) {
								System.out.println(
										"[1] - List manifestation \n[2] - Remove manifestation \n[3] - Returning \nInput: ");
								int inputCondition = exc1.readWhole();

								if (inputCondition == 1) {
									String type = "";
									String text = "";
									peopleServices.ListManifestation(type, text);
								} else if (inputCondition == 2) {
									String type = "";
									String text = "";
									
									peopleServices.ListManifestation(type, text);
									
									System.out.println("Remove");
									System.out.println("ID: ");
									int id = exc1.readWhole();
									
									peopleServices.removeManifestation(id);
								} else if (inputCondition == 3) {
									System.out.println("returning");
									break;
								} else {
									System.out.println("non-existent number");
								}

							}
						} else {
							System.out.println("incorrect username or password");
						}

					} else if (input3 == 3) {
						// break
						System.out.println("returning");
						break;
					} else {
						System.out.println("non-existent number");
					}
				}
			} else if (input1 == 3) {
				// break
				System.out.println("Leaving");
				break;
			} else {
				System.out.println("non-existent number");
			}

		}
		scan.close();

	}

}
