package com.example.solidproject;

import com.example.solidproject.entity.*;
import com.example.solidproject.enums.ContractType;
import com.example.solidproject.service.ServiceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SolidProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolidProjectApplication.class, args);

		ServiceService serviceService = new ServiceService();
		Scanner scanner=new Scanner(System.in);
		int choix;

		do{
			System.out.println("1-Enregister un service dans une liste");
			System.out.println("2-Enregister un employé dans une liste");
			System.out.println("3-Virer un salaire");
			System.out.println("4-Enregistrer un congé pour un employé");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix){
				case 1:
					Service service = new Service();
					System.out.println("Entrer le nom du service");
					String name = scanner.nextLine();
					serviceService.add(service,name);
					System.out.println("----------------------------------");
					System.out.println("Liste des services");
					serviceService.getAll().forEach(System.out::println);
				case 2:
					Employe employe = null;
					System.out.println("Veuillez choisir le type d'employé");
					System.out.println("1-Journalier");
					System.out.println("2-Contractuel");
					System.out.println("3-Prestataire");
					int typeEmploye = scanner.nextInt();
					switch (typeEmploye){
						case 1:
							employe = new Journalier();
							System.out.println("Veuillez entrer le cout journalier de l'employé");
							((Journalier) employe).setCoutJ(scanner.nextInt());
							System.out.println("Veuillez Entrer le nombre d'heures de l'employé");
							((Journalier) employe).setNbreJours(scanner.nextInt());
						case 2:
							employe = new Contractuel();
							System.out.println("Veuillez entrer le code du service");
							String codeService = scanner.nextLine();
							Service s = serviceService.getByCode(codeService);
							if(s==null){
								System.out.println("Service introuvable");
							}else{
								System.out.println("Veuillez choisir le type de contrat");
								System.out.println("1-CDI");
								System.out.println("2-CDD");
								int contrat = scanner.nextInt();
								if(contrat==1||contrat==2){
									((Contractuel) employe).setContractType(ContractType.getValue(contrat));
								}else{
									System.out.println("Type de contrat introuvable");
								}
							}
						case 3:
							employe = new Prestataire();
							System.out.println("Veuillez entrer la période de service");
							((Prestataire) employe).setCoutService(scanner.nextInt());
							System.out.println("Veuillez entrer le cout de service");
							((Prestataire) employe).setPeriodeService(scanner.nextInt());

					}
			}

		}while (choix!=5);
	}

}
