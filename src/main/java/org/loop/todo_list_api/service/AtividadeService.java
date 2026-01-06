package org.loop.todo_list_api.service;

import org.loop.todo_list_api.dto.AtividadeDiaDTO;
import org.loop.todo_list_api.entity.AtividadeEntity;
import org.loop.todo_list_api.enums.TipoAtividade;
import org.loop.todo_list_api.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    // 🔹 Registrar criação de tarefa
    public void registrarCriacaoTarefa() {
        AtividadeEntity atividade = new AtividadeEntity();
        atividade.setData(LocalDate.now());
        atividade.setTipo(TipoAtividade.CRIAR_TAREFA);

        atividadeRepository.save(atividade);
    }

    // 🔹 Registrar conclusão de tarefa
    public void registrarConclusaoTarefa() {
        AtividadeEntity atividade = new AtividadeEntity();
        atividade.setData(LocalDate.now());
        atividade.setTipo(TipoAtividade.CONCLUIR_TAREFA);

        atividadeRepository.save(atividade);
    }

    // 🔹 Dados do heatmap (quadradinhos)
    public List<AtividadeDiaDTO> buscarAtividadesPorPeriodo(
            LocalDate inicio,
            LocalDate fim
    ) {

        List<Object[]> resultados =
                atividadeRepository.contarAtividadesPorDia(inicio, fim);

        return resultados.stream().map(obj ->
                new AtividadeDiaDTO( (LocalDate) obj[0], (Long) obj[1])
        ).toList();
    }

}
