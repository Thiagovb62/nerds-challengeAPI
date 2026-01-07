package com.example.nerds_api.Model.Entity;


import com.example.nerds_api.Model.enums.TipoEquipamento;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "equipamentos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Equipamento {

    @Id
    private Long numeroSerie;
    private String nome;
    @Enumerated
    private TipoEquipamento tipoEquipamento;
}
