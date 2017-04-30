package org.issatso.mspi;

import org.issatso.mspi.entities.Auteur;
import org.issatso.mspi.entities.Commentaire;
import org.issatso.mspi.entities.Message;
import org.issatso.mspi.metier.IMetier;
import org.issatso.mspi.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevoirApplication implements CommandLineRunner {
	@Autowired
	IMetier metier;
	public static void main(String[] args) {
		SpringApplication.run(DevoirApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		/*metier.messageMotCle(0,6,"").forEach(message -> {
			Auteur a=new Auteur("honor@gmail.com","");
			metier.addCommentaire(new Commentaire("Impossible"+message.getIdMessage(),a,message));
		});*/
	}
}
