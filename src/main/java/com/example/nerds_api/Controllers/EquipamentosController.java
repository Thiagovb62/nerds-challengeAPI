package com.example.nerds_api.Controllers;


import com.example.nerds_api.Model.Dto.EquipamentoRequestDto;
import com.example.nerds_api.Model.Dto.EquipamentoUpdateDto;
import com.example.nerds_api.Model.Entity.Equipamento;
import com.example.nerds_api.Services.EquipamentosService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;

@RestController()
@RequestMapping("/equipamentos")
public class EquipamentosController {

    private final EquipamentosService equipamentosService;

    public EquipamentosController(EquipamentosService equipamentosService) {
        this.equipamentosService = equipamentosService;
    }


    @GetMapping(path = "/all", produces = "application/json")
    @Operation(summary = "Procurar todos os equipamentos")
    public ResponseEntity<List<Equipamento>> getAllEquipamentos(){
        return ResponseEntity.ok(equipamentosService.findAllEquipamentos());
    }

    @GetMapping(path = "/NumSerie", produces = "application/json")
    @Operation(summary = "Procurar um equipamento pelo número de série")
    public ResponseEntity<Equipamento> getEquipamentoByNumeroSerie(@RequestParam Long numeroSerie){
        return ResponseEntity.ok(equipamentosService.findEquipamentoByNumeroSerie(numeroSerie));
    }

    @GetMapping(path = "/tipo", produces = "application/json")
    @Operation(summary = "Procurar equipamentos pelo seu tipo")
    public ResponseEntity<List<Equipamento>> getEquipamentoByTipo(@RequestParam String tipo){
        return ResponseEntity.ok(equipamentosService.findAllByTipoEquipamento(tipo));
    }

    @GetMapping(path = "/nome", produces = "application/json")
    @Operation(summary = "Procurar equipamentos pelo nome")
    public ResponseEntity<List<Equipamento>> getEquipamentoByNome(@RequestParam String nome){
        return ResponseEntity.ok(equipamentosService.findEquipamentoByNome(nome));
    }

    @PostMapping (path = "/registrar", consumes = "application/json", produces = "application/json")
    @Operation(summary = "Salvar um novo equipamento")
    public ResponseEntity<Equipamento> saveEquipamento(@RequestBody @Valid EquipamentoRequestDto equipamento, UriComponentsBuilder uriBuilder){
        Equipamento equipamentoSalvo = equipamentosService.saveEquipamento(equipamento);
        var uri = uriBuilder.path("/equipamentos/{numeroSerie}").buildAndExpand(equipamentoSalvo.getNumeroSerie()).toUri();
        return ResponseEntity.created(uri).body(equipamentoSalvo);
    }

     @PutMapping(path = "/atualizar/{numeroSerie}", consumes = "application/json", produces = "application/json")
    @Operation(summary = "Atualizar um equipamento pelo número de série")
    public ResponseEntity<Equipamento> updateEquipamento(@RequestBody EquipamentoUpdateDto equipamento, @PathVariable Long numeroSerie){
        Equipamento equipamentoAtualizado = equipamentosService.updateEquipamento(equipamento, numeroSerie);
        return ResponseEntity.ok(equipamentoAtualizado);
    }

    @Operation(summary = "Deletar um equipamento pelo número de série")
    @DeleteMapping("/deletar/{numeroSerie}")
    public ResponseEntity deleteEquipamento(@PathVariable Long numeroSerie){
        equipamentosService.deleteEquipamento(numeroSerie);
        return ResponseEntity.noContent().build();
    }

}
