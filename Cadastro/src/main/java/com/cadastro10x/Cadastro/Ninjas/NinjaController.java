package com.cadastro10x.Cadastro.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/ninjas")
    @Operation(summary = "mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas")
    public String boasvindas(){

        return "Essa é minha primeira mensagem nessa rota";
    }


    //Adicionar ninjas (create)
    @PostMapping("/criar")
    @Operation(summary = "cria um novo ninja", description = "rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "ninja criado com sucesso"),
          @ApiResponse(responseCode = "400", description = "erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (id): " + novoNinja.getId());
    }

    //mostrar todos os ninjas (read)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //mostrar todos os ninjas po ID (read)
    @GetMapping("/listar/{id}")
    @Operation(summary = "lista o ninja por ID", description = "rota lista o ninja por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ninja não encontrado")
    })
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja não encontrado");
        }
    }

    //alterar por id
    @PutMapping("/alterar/{id}")
    @Operation(summary = "altera o ninja por ID", description = "rota altera o ninja por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ninja não encontrado")
    })
    public ResponseEntity<String> alterarNinjaPorId(
            @Parameter(description = "Usuario manda o ID no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "usuario manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaModel ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinja(id, (NinjaDTO) ninjaAtualizado);

        if (ninja != null){
            return ResponseEntity.ok(ninja.toString());
        }else {
            return (ResponseEntity<String>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

    }

    private void body(String ninjaNãoEncontrado) {
    }

    //deletar ninjas (delete)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja não foi encontrado");
        }
    }
}
