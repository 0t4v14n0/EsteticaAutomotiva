package com.esteticaAutomotiva.domain.agendamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.esteticaAutomotiva.domain.agenda.Agenda;
import com.esteticaAutomotiva.domain.agenda.AgendaService;
import com.esteticaAutomotiva.domain.agenda.dto.DataDetalhesAgenda;
import com.esteticaAutomotiva.domain.agenda.dto.DataRegistroAgenda;
import com.esteticaAutomotiva.domain.agenda.enums.StatusAgenda;
import com.esteticaAutomotiva.domain.agendamento.dto.DataAtualizarAgendamento;
import com.esteticaAutomotiva.domain.agendamento.dto.DataDetalhesAgendamento;
import com.esteticaAutomotiva.domain.pessoa.cliente.Cliente;
import com.esteticaAutomotiva.domain.pessoa.cliente.ClienteRepository;
import com.esteticaAutomotiva.domain.pessoa.cliente.ClienteService;

import jakarta.validation.Valid;

@Service
public class AgendamentoService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AgendaService agendaService;
	
	// AGENDA HORARIO
	public ResponseEntity<DataDetalhesAgenda> agendar(@Valid DataRegistroAgenda dataRegistroConsulta, String name) {
		
		Cliente cliente = clienteService.buscaClienteLogin(name);
		
		Agenda agenda = agendaService.reservaHorario(dataRegistroConsulta.id());
		
		Agendamento agendamento = new Agendamento();
		agendamento.setCliente(cliente);
		agendamento.setData(agenda.getHorario());
		
		cliente.setQuantidadeAgendamento(cliente.getQuantidadeAgendamento() + 1);

		clienteRepository.save(cliente);
		agendamentoRepository.save(agendamento);
		
		return ResponseEntity.ok(new DataDetalhesAgenda(agenda));
	}

	public ResponseEntity<DataDetalhesAgendamento> reagendar(@Valid DataAtualizarAgendamento dataAtualizarAgendamento, String name) {

	    Agendamento agendamento = agendamentoRepository.findById(dataAtualizarAgendamento.idAgendamento())
	                                     			   .orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada!"));

	    agendaService.mudarStatusAgenda(agendamento.getData(), StatusAgenda.DISPONIVEL);

	    Agenda agenda = agendaService.reservaHorario(dataAtualizarAgendamento.idHorario());

	    agendamento.setData(agenda.getHorario());

	    return ResponseEntity.ok(new DataDetalhesAgendamento(agendamento));
	}

	public ResponseEntity<DataDetalhesAgendamento> agendamentos(String name, StatusAgenda statusAgenda) {
		
		List<Agendamento> agenda = agendamentoRepository.findByLoginAndStatusAgenda(name,statusAgenda);
		
		return ResponseEntity.ok(null);
	}

}
