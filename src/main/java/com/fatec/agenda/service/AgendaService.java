package com.fatec.agenda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.agenda.dtos.AgendaResponse;
import com.fatec.agenda.mappers.AgendaMapper;
import com.fatec.agenda.repositories.AgendaRepository;

@Service
public class AgendaService {
    
    @Autowired
    private AgendaRepository repository;

    public List <AgendaResponse> getAllAgendas(){
        return repository.findAll().stream().map(p -> AgendaMapper.toDTO(p)).collect(Collectors.toList());
    }
}
