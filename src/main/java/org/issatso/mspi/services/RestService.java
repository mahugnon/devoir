package org.issatso.mspi.services;

import java.util.List;

import org.issatso.mspi.entities.Auteur;
import org.issatso.mspi.entities.Commentaire;
import org.issatso.mspi.entities.Message;
import org.issatso.mspi.metier.IMetier;
import org.issatso.mspi.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController(value="/services")
public class RestService {



	@Autowired
private IMetier metier;
	@Autowired
	AuteurRepository auteurRepository;
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String hello(){
		return "hello";
	}
	@RequestMapping(value="/auteurs",method=RequestMethod.POST)
	public Auteur addAuteur(@RequestBody Auteur a) {
		return metier.addAuteur(a);
	}
	@RequestMapping(value="/commentaires",method=RequestMethod.POST)
	public Commentaire addCommentaire(@RequestBody Commentaire m) {
		return metier.addCommentaire(m);
	}
	@RequestMapping(value="/messages",method=RequestMethod.POST)
	public Message addMessage(@RequestBody Message m) {
		return metier.addMessage(m);
	}
	@RequestMapping(value="/auteurs/{email}",method=RequestMethod.DELETE)
	public void deleteAuteur(@PathVariable(value="email")String id) {
		metier.deleteAuteur(id);
	}
	@RequestMapping(value="/commentaires/{id}",method=RequestMethod.DELETE)
	public void deleteCommentaire(@PathVariable(value="id")Integer id) {
		metier.deleteCommentaire(id);
	}
	@RequestMapping(value="/messages",method=RequestMethod.DELETE)
	public void deleteMessage(@PathVariable(value="id")Integer id) {
		metier.deleteMessage(id);
	}

	@RequestMapping(value="/auteurs/{email}",method=RequestMethod.GET)
	public Auteur findOneAuteur( @PathVariable String email) {
		return null;
	}
	@RequestMapping(value="/commentaires/{id}",method=RequestMethod.GET)
	public Commentaire findOneCommentaire(@PathVariable(value="id")Integer id) {
		return metier.findOneCommentaire(id);
	}
	@RequestMapping(value="/messages/{id}",method=RequestMethod.GET)
	public Message findOneMessage(@PathVariable(value="id")Integer id) {
		return metier.findOneMessage(id);
	}
	@RequestMapping(value="/auteurs",method=RequestMethod.GET)
	public List<Auteur> getAllAuteur() {
		return metier.getAllAuteur();
	}
	@RequestMapping(value="/messages/{id}/commentaires",method=RequestMethod.GET)
	public List<Commentaire> getCommentaireByMessage(@PathVariable(value="id")Integer id) {
		return metier.getCommentaireByMessage(id);
	}
	@RequestMapping(value="/auteurs/{email}/messages",method=RequestMethod.GET)
	public List<Message> getMessagesByAuteur(@PathVariable(value="email")String email) {
		return metier.getMessagesByAuteur(email);
	}

	@RequestMapping(value="/auteurs",method=RequestMethod.PUT)
	public Auteur updateAuteur(@RequestBody Auteur a) {
		return metier.updateAuteur(a);
	}
	@RequestMapping(value="/commentaires",method=RequestMethod.PUT)
	public Commentaire updateCommentaire(@RequestBody Commentaire m) {
		return metier.updateCommentaire(m);
	}

	@RequestMapping(value="/messages",method=RequestMethod.PUT)
	public Message updateMessage(@RequestBody Message m) {
		return metier.updateMessage(m);
	}
	/*@RequestMapping(value="/messages",method=RequestMethod.GET)
	public List<Message> findAllMessage() {
		return metier.findAllMessage();
	}*/
	/*@RequestMapping(value = "/messages",method = RequestMethod.GET)
	public Page<Message> findPageMessage(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam int size) {
		return metier.findPageMessage(page, size);

	}*/
@RequestMapping(value = "/messages",method = RequestMethod.GET)
	public Page<Message> messageMotCle(@RequestParam(defaultValue = "0") int page,
									   @RequestParam(defaultValue = "6") int size,
									   @RequestParam(defaultValue = "") String motCle) {
		return metier.messageMotCle(page, size, motCle);
	}
}
