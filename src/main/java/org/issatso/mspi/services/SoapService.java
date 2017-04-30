package org.issatso.mspi.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.issatso.mspi.entities.Auteur;
import org.issatso.mspi.entities.Commentaire;
import org.issatso.mspi.entities.Message;
import org.issatso.mspi.metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@WebService
@Component
public class SoapService {
	@Autowired
	IMetier metier;

	@WebMethod
    public List<Message> findAllMessage() {
        return metier.findAllMessage();
    }
    @WebMethod
    public Auteur addAuteur(@WebParam(name = "auteur") Auteur a) {
        return metier.addAuteur(a);
    }
@WebMethod
    public void addCommentaire(@WebParam(name = "commentaire")Commentaire m) {
        metier.addCommentaire(m);
    }
@WebMethod
    public void addMessage(@WebParam(name = "message")Message m) {
        metier.addMessage(m);
    }
@WebMethod
    public void deleteAuteur(@WebParam(name = "idAuteur")String id) {
        metier.deleteAuteur(id);
    }
@WebMethod
    public void deleteCommentaire(@WebParam(name = "idCmnt")Integer id) {
        metier.deleteCommentaire(id);
    }
@WebMethod
    public void deleteMessage(@WebParam(name = "idSmg")Integer id) {
        metier.deleteMessage(id);
    }
@WebMethod
    public Auteur findOneAuteur(@WebParam(name = "email")String email) {
        return metier.findOneAuteur(email);
    }
@WebMethod
    public Commentaire findOneCommentaire(@WebParam(name = "idcmnt")Integer id) {
        return metier.findOneCommentaire(id);
    }
@WebMethod
    public Message findOneMessage(@WebParam(name = "idSmg")Integer id) {
        return metier.findOneMessage(id);
    }
@WebMethod
    public List<Auteur> getAllAuteur() {
        return metier.getAllAuteur();
    }
@WebMethod
    public List<Commentaire> getCommentaireByMessage(@WebParam(name = "IdSmg")Integer id) {
        return metier.getCommentaireByMessage(id);
    }
@WebMethod
    public List<Message> getMessagesByAuteur(@WebParam(name = "emailAuteur")String email) {
        return metier.getMessagesByAuteur(email);
    }
 @WebMethod
    public void updateAuteur(@WebParam(name = "auteur")Auteur a) {
        metier.updateAuteur(a);
    }
@WebMethod
    public void updateCommentaire(@WebParam(name = "commentaire")Commentaire m) {
        metier.updateCommentaire(m);
    }
@WebMethod
    public void updateMessage(@WebParam(name = "message")Message m) {
        metier.updateMessage(m);
    }
}
