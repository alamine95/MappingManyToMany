package sn.esmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.esmt.domaine.*;
import sn.esmt.repository.*;


@SpringBootApplication
public class MapingManyToManyApplication implements CommandLineRunner {

	@Autowired
	private ProfesseurRepository repoProfesseur;
	@Autowired
	private ProjetRechercheRepository repoProjet;
	
	public static void main(String[] args) {
		SpringApplication.run(MapingManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Professeur prof1 = new Professeur();
		prof1.setNom("Fall");
		prof1.setPrenom("Seydina");
		
		Professeur prof2 = new Professeur();
		prof2.setNom("Sow");
		prof2.setPrenom("Lamda");
		
		ProjetRecherche pr1 = new ProjetRecherche();
		pr1.setTheme("Traitement des image");
		
		ProjetRecherche pr2 = new ProjetRecherche();
		pr2.setTheme("Réseaux des neurones CNN");
		
		ProjetRecherche pr3 = new ProjetRecherche();
		pr3.setTheme("Optimatisation des Réseaux");
		
		prof1.assignerProjetProfesseur(pr1);
		prof1.assignerProjetProfesseur(pr2);
		prof1.assignerProjetProfesseur(pr3);
		pr1.assignerProfesseurProjet(prof1);
		pr2.assignerProfesseurProjet(prof1);
		pr3.assignerProfesseurProjet(prof1);
		
		
		prof2.assignerProjetProfesseur(pr1);
		prof2.assignerProjetProfesseur(pr2);
		
		pr1.assignerProfesseurProjet(prof2);
		pr2.assignerProfesseurProjet(prof2);
		
		repoProfesseur.save(prof1);
		repoProfesseur.save(prof2);
		
		repoProjet.save(pr1);
		repoProjet.save(pr2);
		repoProjet.save(pr3);
	}

}
