package com.example.nerds_api.Services;



import com.example.nerds_api.Model.Dto.EquipamentoRequestDto;
import com.example.nerds_api.Model.Dto.EquipamentoUpdateDto;
import com.example.nerds_api.Model.Entity.Equipamento;

import java.util.List;

public interface EquipamentosService {

    List<Equipamento> findAllEquipamentos();

    Equipamento findEquipamentoByNumeroSerie(Long numeroSerie);

    List<Equipamento> findAllByTipoEquipamento(String tipo);

    List<Equipamento> findEquipamentoByNome(String nome);

    Equipamento saveEquipamento(EquipamentoRequestDto equipamento);

    Equipamento updateEquipamento(EquipamentoUpdateDto equipamento,Long numeroSerie);

    void deleteEquipamento(Long numeroSerie);
}
