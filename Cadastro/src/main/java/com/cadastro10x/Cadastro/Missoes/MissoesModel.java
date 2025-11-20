package com.cadastro10x.Cadastro.Missoes;

import com.cadastro10x.Cadastro.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data //getters and Setters
@ToString
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dificuldade")
    private String dificuldade;

    //@OneToMany uma Missao pode ter muitos ninjas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninja;

//======================
    public void setId(Long id) {
    }
//======================
}
