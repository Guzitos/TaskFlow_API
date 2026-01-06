package org.loop.todo_list_api.controller;

import org.loop.todo_list_api.dto.AtividadeDiaDTO;
import org.loop.todo_list_api.service.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/atividades")
@CrossOrigin(origins = "http://localhost:5173")
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @GetMapping
    public List<AtividadeDiaDTO> buscarAtividades(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim
    ) {
        return atividadeService.buscarAtividadesPorPeriodo(inicio, fim);
    }
}
