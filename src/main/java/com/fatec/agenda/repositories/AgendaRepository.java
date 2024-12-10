package com.fatec.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.agenda.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    
}
