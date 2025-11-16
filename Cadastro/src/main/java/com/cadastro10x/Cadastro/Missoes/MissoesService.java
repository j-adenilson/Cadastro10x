package com.cadastro10x.Cadastro.Missoes;

import java.util.List;
import java.util.Optional;

public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Criar uma nova missão
    public MissoesModel criarMissoes(MissoesModel missoes){
        return missoesRepository.save(missoes);
    }

    //Listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Listar missoes por ID
    public MissoesModel listarMissoesPorId(long id){
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //Atualizar missoes por ID
    public MissoesModel atualizarMissoes(Long id, MissoesModel missoesAtualizada){
        if (missoesRepository.existsById(id)){
            missoesAtualizada.setId(id);
            return missoesRepository.save(missoesAtualizada);
        }
        return null;
    }

    //Deletar missoes por ID
    public void deletarMissoesPorId(Long id){
        missoesRepository.deleteById(id);
    }
}
