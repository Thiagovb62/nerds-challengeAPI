package com.example.nerds_api.Repository;


import com.example.nerds_api.Model.Entity.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface EquipamentosRepositry extends JpaRepository<Equipamento,Long> {

    Equipamento deleteByNumeroSerie(Long numeroSerie);

    boolean existsByNumeroSerie(Long numeroSerie);

    List<Equipamento> findAllByNomeIgnoreCase(String nome);

}
