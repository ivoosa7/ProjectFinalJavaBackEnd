package com.fatec.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.agenda.dtos.AgendaResponse;
import com.fatec.agenda.service.AgendaService;

@RestController
@RequestMapping("compromissos")
public class AgendaController {
    
    @Autowired
    public AgendaService service;

    //1 EndPoint
    @GetMapping
    public ResponseEntity<List<AgendaResponse>> getAgenda(){
        return ResponseEntity.ok(service.getAllAgendas());
    }
    
}
