package com.esteticaAutomotiva.domain.agendamento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esteticaAutomotiva.domain.agenda.enums.StatusAgenda;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	Optional<Agendamento> findByData(LocalDateTime date);
	
	@Query("SELECT a FROM Agendamento a " +
		       "JOIN a.cliente c " +
		       "WHERE c.login = :login")
	Page<Agendamento> findAllByLogin(@Param("login") String login, 
								Pageable pageable);
	
//	@Query("SELECT a FROM Agendamento a " +
//		       "JOIN a.cliente c " +
//		       "WHERE c.login = :login")
//	List<Agendamento> findByLoginAndStatusAgenda(@Param("login") String login,
//																 StatusAgenda statusAgenda,
//																 Pageable pageable);

}
