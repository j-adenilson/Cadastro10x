package com.cadastro10x.Cadastro.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping//("/missoes")
public class MissoesController {

    private MissoesService missoesService;

//    public MissoesController(MissoesService missoesService) {
//        this.missoesService = missoesService;
//    }

    @GetMapping("/missoes")
    public String missoes(){
        return "rota de misoes";
    }


    //criar missoes
    @PostMapping("/criarMissoes")
    public MissoesModel criarMissoes(@RequestBody MissoesModel missoes){
        return missoesService.criarMissoes(missoes);
    }

    //listar missoes
    @GetMapping("/listarMissoes")
    public List<MissoesModel> listarMissoes(){
        return missoesService.listarMissoes();
    }

    //Listar missoes por id
    @GetMapping("/listarMissoesPorId/{id}")
    public MissoesModel litarMissoesPorId(@PathVariable Long id){
        return missoesService.listarMissoesPorId(id);
    }

    //alterar missoes por id
    @PostMapping("/alterarMissoes/{id}")
    public MissoesModel alterarMissoesPorId(@PathVariable long id, @RequestBody MissoesModel missoesAtualizada){
        return missoesService.atualizarMissoes(id, missoesAtualizada);
    }

    //deletar missoes por ID
    @DeleteMapping("/deletarMissoesPorId/{id}")
    public void deletarMissoesPorId(@PathVariable Long id){
        missoesService.deletarMissoesPorId(id);
    }
}
