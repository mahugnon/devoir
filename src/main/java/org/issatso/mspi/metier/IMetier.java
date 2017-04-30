package org.issatso.mspi.metier;

import java.util.List;

import org.issatso.mspi.entities.Auteur;
import org.issatso.mspi.entities.Commentaire;
import org.issatso.mspi.entities.Message;
import org.springframework.data.domain.Page;

public interface IMetier {
	public Auteur addAuteur(Auteur a);

	public  Commentaire addCommentaire(Commentaire m);

	public   Message addMessage(Message m);

	    void deleteAuteur(String id);

	    void deleteCommentaire(Integer id);

	    void deleteMessage(Integer id);

	    Auteur findOneAuteur(String email);

	    Commentaire findOneCommentaire(Integer id);

	    Message findOneMessage(Integer id);

	    List<Auteur> getAllAuteur();

	    List<Commentaire> getCommentaireByMessage(Integer id);

	    List<Message> getMessagesByAuteur(String email);

	    public  Auteur updateAuteur(Auteur a);

	    public Commentaire updateCommentaire(Commentaire m);

	    public Message updateMessage(Message m);
	    public List<Message> findAllMessage();
	    public Page<Message> findPageMessage(int page,int size);
	    public Page<Message> messageMotCle(int page,int size,String motCle);
}
