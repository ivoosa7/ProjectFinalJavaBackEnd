package com.fatec.agenda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.agenda.dtos.AgendaRequest;
import com.fatec.agenda.dtos.AgendaResponse;
import com.fatec.agenda.entities.Agenda;
import com.fatec.agenda.mappers.AgendaMapper;
import com.fatec.agenda.repositories.AgendaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendaService {
    
    @Autowired
    private AgendaRepository repository;

    //1 Service
    public List <AgendaResponse> getAllAgendas(){
        return repository.findAll().stream().map(p -> AgendaMapper.toDTO(p)).collect(Collectors.toList());
    }

    //2 Service
    public AgendaResponse getAgendaById(long id){
        Agenda agenda = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Não há agendamento")
        );

        return AgendaMapper.toDTO(agenda);
    }

    //3 Service 
    public AgendaResponse saveAgenda(AgendaRequest agenda){
        Agenda newAgenda = repository.save(AgendaMapper.toEntity(agenda));
        return AgendaMapper.toDTO(newAgenda);
    }

    //4 Service
    public void updateAgenda (AgendaRequest agenda, long id){
        Agenda aux = repository.getReferenceById(id);

        aux.setTitulo(agenda.titulo());
        aux.setDescricao(agenda.descricao());
        aux.setData(agenda.data());
        aux.setHora(agenda.hora());
        aux.setLocal(agenda.local());

        repository.save(aux);
    }

    //5 Service
    public void delete(long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }else{
            throw new EntityNotFoundException("Compromisso não marcado");
        }
    }
}
