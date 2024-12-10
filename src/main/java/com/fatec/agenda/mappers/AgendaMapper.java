package com.fatec.agenda.mappers;

import com.fatec.agenda.dtos.AgendaRequest;
import com.fatec.agenda.dtos.AgendaResponse;
import com.fatec.agenda.entities.Agenda;

public class AgendaMapper {
    //Response Dto
    public static AgendaResponse toDTO(Agenda agenda){
        return new AgendaResponse(
            agenda.getId(),
            agenda.getTitulo(),
            agenda.getDescricao(),
            agenda.getData(),
            agenda.getHora(),
            agenda.getLocal()
        );
    }

    //Request Dto
    public static Agenda toEntity(AgendaRequest agendaRequest){
        Agenda agenda = new Agenda();
        agenda.setTitulo(agendaRequest.titulo());
        agenda.setDescricao(agendaRequest.descricao());
        agenda.setData(agendaRequest.data());
        agenda.setHora(agendaRequest.hora());
        agenda.setLocal(agendaRequest.local());

        return agenda;
    }
}
