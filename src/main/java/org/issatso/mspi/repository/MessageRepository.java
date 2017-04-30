package org.issatso.mspi.repository;

import java.util.List;

import org.issatso.mspi.entities.Auteur;
import org.issatso.mspi.entities.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	public List<Message> findMessagesByAuteurBean(Auteur auteur);
	@Query("select  m from  Message m order by m.idMessage desc ")
	public Page<Message> listMessage(Pageable pageable);
	@Query("select m from Message m where m.contenu like :x")
	public Page<Message> messageParMotCle(Pageable pageable,@Param("x") String motCle);
}
