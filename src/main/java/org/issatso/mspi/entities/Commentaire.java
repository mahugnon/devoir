package org.issatso.mspi.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the commentaire database table.
 * 
 */
@Entity
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
@XmlRootElement
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commentaire")
	private int idCommentaire;

	private String contenu;

	//bi-directional many-to-one association to Auteur
	@ManyToOne
	@JoinColumn(name="auteur")
	private Auteur auteurBean;

	//bi-directional many-to-one association to Message
	@ManyToOne
	@JoinColumn(name="id_message")
	private Message message;

	public Commentaire() {
	}

	public int getIdCommentaire() {
		return this.idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Auteur getAuteurBean() {
		return this.auteurBean;
	}

	public void setAuteurBean(Auteur auteurBean) {
		this.auteurBean = auteurBean;
	}

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}