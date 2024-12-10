package com.fatec.agenda.dtos;

public record AgendaRequest(
            String titulo, 
            String descricao,
            String data,  
            String hora, 
            String local
) {
    
}
