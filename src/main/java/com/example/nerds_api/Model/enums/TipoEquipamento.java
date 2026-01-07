package com.example.nerds_api.Model.enums;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema
public enum TipoEquipamento {
       INFORMATICA(1, "INFORMATICA"),
       PERIFERICO(2, "PERIFERICO"),
       REDE(3, "REDE"),
       OUTRO(4, "OUTRO");

       private final int valor;
       @Getter
       private final String descricao;

       TipoEquipamento(int valor, String descricao) {
           this.valor = valor;
           this.descricao = descricao;
       }

    public static TipoEquipamento fromDescricao(String descricao) {
           for (TipoEquipamento tipo : TipoEquipamento.values()) {
               if (tipo.getDescricao().equalsIgnoreCase(descricao)) {
                   return tipo;
               }
           }
           throw new IllegalArgumentException("Descrição inválida para TipoEquipamento: " + descricao);
       }
}
