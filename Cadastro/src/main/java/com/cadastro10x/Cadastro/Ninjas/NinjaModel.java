package com.cadastro10x.Cadastro.Ninjas;


import com.cadastro10x.Cadastro.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// JPA = Java Persistence API
//Entity transforma uma classe em uma entidade do banco de dados

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data //getters and Setters
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //@manyToone um ninja tem apenas uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_id")//Foreing key ou chave estrangeira
    private MissoesModel missoes;



}
