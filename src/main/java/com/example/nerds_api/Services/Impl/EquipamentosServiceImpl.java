package com.example.nerds_api.Services.Impl;


import com.example.nerds_api.Model.Dto.EquipamentoRequestDto;
import com.example.nerds_api.Model.Dto.EquipamentoUpdateDto;
import com.example.nerds_api.Model.Entity.Equipamento;
import com.example.nerds_api.Model.enums.TipoEquipamento;
import com.example.nerds_api.Repository.EquipamentosRepositry;
import com.example.nerds_api.Services.EquipamentosService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.Transient;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EquipamentosServiceImpl implements EquipamentosService {

    private final EquipamentosRepositry equipamentosRepositry;

    public EquipamentosServiceImpl(EquipamentosRepositry equipamentosRepositry) {
        this.equipamentosRepositry = equipamentosRepositry;
    }

    public List<Equipamento> findAllEquipamentos(){
        return equipamentosRepositry.findAll();
    }



    public Equipamento findEquipamentoByNumeroSerie(Long numeroSerie){
        return equipamentosRepositry.findById(numeroSerie).orElseThrow(() -> new NullPointerException("Equipamento não encontrado com número de série: " + numeroSerie));
    }

    public List<Equipamento> findEquipamentoByNome(String nome){
        List<Equipamento> equipamento = equipamentosRepositry.findAllByNomeIgnoreCase(nome);
        if (equipamento == null) {
            throw new NullPointerException("Nenhum equipamento encontrado com esse nome: " + nome);
        }
        return equipamento;
    }

    public List<Equipamento> findAllByTipoEquipamento(String tipoEquipamento){
        List<Equipamento> equipamentos = equipamentosRepositry.findAll();
        return equipamentos.stream()
                .filter(equipamento -> equipamento.getTipoEquipamento().getDescricao().equalsIgnoreCase(tipoEquipamento))
                .toList();
    }

    public Equipamento saveEquipamento(EquipamentoRequestDto equipamento){
        if (equipamentosRepositry.existsByNumeroSerie(equipamento.numeroSerie())) {
            throw new EntityExistsException("Equipamento com esse número de série já existe.");
        }
        Equipamento novoEquipamento = new Equipamento();
        novoEquipamento.setNumeroSerie(equipamento.numeroSerie());
        novoEquipamento.setNome(equipamento.nome());
        novoEquipamento.setTipoEquipamento(TipoEquipamento.fromDescricao(equipamento.tipo().toUpperCase()));
        return equipamentosRepositry.save(novoEquipamento);
    }

    public Equipamento updateEquipamento(EquipamentoUpdateDto equipamento, Long numeroSerie){
        Equipamento equipamentoExistente = this.findEquipamentoByNumeroSerie(numeroSerie);
        if(equipamentoExistente == null){
            throw new NullPointerException("Equipamento não encontrado com número de série: " + numeroSerie);
        }
        if (equipamento.nome() != null && !equipamento.nome().isBlank()) {
            equipamentoExistente.setNome(equipamento.nome());
        }else {
            equipamentoExistente.setNome(equipamentoExistente.getNome());
        }
        if (equipamento.tipo() != null && !equipamento.tipo().isBlank()) {
            equipamentoExistente.setTipoEquipamento(TipoEquipamento.fromDescricao(equipamento.tipo().toUpperCase()));
        }else {
            equipamentoExistente.setTipoEquipamento(equipamentoExistente.getTipoEquipamento());
        }
        return equipamentosRepositry.save(equipamentoExistente);
    }

    @Transient
    public void deleteEquipamento(Long numeroSerie){
        Equipamento equipamento = this.findEquipamentoByNumeroSerie(numeroSerie);
        equipamentosRepositry.delete(equipamento);
    }
}
