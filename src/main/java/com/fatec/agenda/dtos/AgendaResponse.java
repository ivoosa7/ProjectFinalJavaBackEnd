package com.fatec.agenda.dtos;

public record AgendaResponse(
            long id,
            String titulo, 
            String descricao,
            String data,
            String hora, 
            String local
) {
    
}
