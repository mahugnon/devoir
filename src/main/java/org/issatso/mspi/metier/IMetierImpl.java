package org.issatso.mspi.metier;


import java.util.List;

import org.issatso.mspi.entities.Auteur;
import org.issatso.mspi.entities.Commentaire;
import org.issatso.mspi.entities.Message;
import org.issatso.mspi.repository.AuteurRepository;
import org.issatso.mspi.repository.CommentaireRepository;
import org.issatso.mspi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class IMetierImpl implements IMetier {
	@Autowired
	private AuteurRepository auteurRepository;
	@Autowired

	private MessageRepository messageRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Override
	public Auteur addAuteur(Auteur a) {
		// TODO Auto-generated method stub
		return auteurRepository.save(a);
	}
	@Override
	public Commentaire addCommentaire(Commentaire m) {
		// TODO Auto-generated method stub
		return commentaireRepository.save(m);
	}
	@Override
	public Message addMessage(Message m) {
		// TODO Auto-generated method stub
		return messageRepository.save(m);
	}
	@Override
	public void deleteAuteur(String id) {
		
		auteurRepository.delete(id);
	}
	@Override
	public void deleteCommentaire(Integer id) {
		commentaireRepository.delete(id);
	}
	@Override
	public void deleteMessage(Integer id) {
		// TODO Auto-generated method stub
		messageRepository.delete(id);
		
	}
	@Override
	public Auteur findOneAuteur(String email) {
		// TODO Auto-generated method stub
		Auteur auteur=auteurRepository.findOne(email);
		if(auteur==null) throw new RuntimeException("Ce auteur n'existe pas");
		return auteur;
	}
	@Override
	public Commentaire findOneCommentaire(Integer id) {
		// TODO Auto-generated method stub
		Commentaire commentaire=commentaireRepository.findOne(id);
		if(commentaire==null)throw new RuntimeException("Ce commentaire n'existe pas");
		return commentaire;
	}
	@Override
	public Message findOneMessage(Integer id) {
Message message=messageRepository.findOne(id);
if(message==null)throw new RuntimeException("Ce message n'existe pas");
return message;
	}
	@Override
	public List<Auteur> getAllAuteur() {
		// TODO Auto-generated method stub
		return auteurRepository.findAll();
	}
	@Transactional
	@Override
	public List<Commentaire> getCommentaireByMessage(Integer id) {
		// TODO Auto-generated method stub
		return commentaireRepository.findCommentairesByMessage(findOneMessage(id));
	}
	@Transactional
	@Override
	public List<Message> getMessagesByAuteur(String email) {
		return messageRepository.findMessagesByAuteurBean(findOneAuteur(email));
	}
	@Override
	public Auteur updateAuteur(Auteur a) {
		return auteurRepository.save(a);
	}
	@Override
	public Commentaire updateCommentaire(Commentaire m) {

		return commentaireRepository.save(m);
	}
	@Override
	public Message updateMessage(Message m) {

		return messageRepository.save(m);
	}
	@Override
	public List<Message> findAllMessage() {
		return messageRepository.findAll();
	}

	@Override
	public Page<Message> findPageMessage(int page, int size) {
		return messageRepository.listMessage(new PageRequest(page,size));
	}

	@Override
	public Page<Message> messageMotCle(int page, int size, String motCle) {
		return messageRepository.messageParMotCle(new PageRequest(page,size),"%"+motCle+"%");
	}

}
