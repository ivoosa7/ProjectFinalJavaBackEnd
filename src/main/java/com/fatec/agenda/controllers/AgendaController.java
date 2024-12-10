package com.fatec.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.agenda.dtos.AgendaRequest;
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

    //2 EndPoint
    @GetMapping("{id}")
    public ResponseEntity<AgendaResponse> getAgenda(@PathVariable long id){
        return ResponseEntity.ok(service.getAgendaById(id));
    }

    //3 EndPoint
    @PostMapping()
    public ResponseEntity<AgendaResponse> saveNewAgenda(@RequestBody AgendaRequest agenda){
        AgendaResponse newAgenda = service.saveAgenda(agenda);
        return ResponseEntity.created(null).body(newAgenda);
    }

    //4 EndPoint
    @PutMapping("{id}")
    public ResponseEntity<Void> updateAgenda(@PathVariable long id, @RequestBody AgendaRequest agenda){
        service.updateAgenda(agenda, id);
        return ResponseEntity.ok().build();
    }

    //5 EndPoint
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
