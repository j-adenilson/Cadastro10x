package com.cadastro10x.Cadastro.Ninjas;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/ninjas")
    public String boasvindas(){

        return "Essa é minha primeira mensagem nessa rota";
    }


    //Adicionar ninjas (create)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //mostrar todos os ninjas (read)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    //mostrar todos os ninjas po ID (read)
    @GetMapping("/listarID")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrar Ninja por ID";
    }

    //alterar dados dos ninjas (update)
    @PutMapping("/alterar")
    public String alterarNinja(){
        return "alterar ninja por id";
    }

    @PutMapping("/alterarID")
    public String alterarNinjaPorId(){
        return "alterar ninja por id";
    }

    //deletar ninjas (delete)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return "deletar ninja por id";
    }
}
