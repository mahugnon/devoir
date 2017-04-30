package org.issatso.mspi.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the auteur database table.
 * 
 */
@Entity
@NamedQuery(name="Auteur.findAll", query="SELECT a FROM Auteur a")
@XmlRootElement
public class Auteur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String email;

	private String nom_Premon;

	//bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy="auteurBean")
	private List<Commentaire> commentaires;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="auteurBean")
	private List<Message> messages;

	public Auteur() {
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom_Premon() {
		return this.nom_Premon;
	}

	public void setNom_Premon(String nom_Premon) {
		this.nom_Premon = nom_Premon;
	}
	@XmlTransient
	@JsonIgnore
	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setAuteurBean(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setAuteurBean(null);

		return commentaire;
	}
	
	@XmlTransient
	@JsonIgnore
	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setAuteurBean(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setAuteurBean(null);

		return message;
	}

}