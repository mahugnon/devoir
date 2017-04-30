package org.issatso.mspi.repository;

import java.util.List;

import org.issatso.mspi.entities.Commentaire;
import org.issatso.mspi.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
	public List<Commentaire> findCommentairesByMessage(Message message);
}
