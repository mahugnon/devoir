package org.issatso.mspi.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
@XmlRootElement
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_message")
	private int idMessage;

	@Lob
	private String contenu;

	//bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy="message")
	@XmlTransient
	@JsonIgnore
	private List<Commentaire> commentaires;

	//bi-directional many-to-one association to Auteur
	@ManyToOne
	@JoinColumn(name="auteur")
	private Auteur auteurBean;

	public Message() {
	}

	public int getIdMessage() {
		return this.idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setMessage(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setMessage(null);

		return commentaire;
	}

	public Auteur getAuteurBean() {
		return this.auteurBean;
	}

	public void setAuteurBean(Auteur auteurBean) {
		this.auteurBean = auteurBean;
	}

}