package com.jayjayAI.MixAnalytics.Service;

import com.jayjayAI.MixAnalytics.Exceptions.RecursoNaoEncontradoException;
import com.jayjayAI.MixAnalytics.Model.InsumoModel;
import com.jayjayAI.MixAnalytics.Repository.InsumoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {

    private final InsumoRepository insumoRepository;

    public InsumoService(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    public List<InsumoModel> listar(){
        return insumoRepository.findAll();
    }

    public InsumoModel cadastrarInsumo(InsumoModel insumoModel){
        return insumoRepository.save(insumoModel);
    }

    public InsumoModel listarPorId(long id){
        return insumoRepository.findById(id)
                .orElseThrow(()-> new RecursoNaoEncontradoException("Produto com o ID" + id + "não encontrado"));
    }

    public InsumoModel atualizarInsumo(Long id, InsumoModel insumoAtualizado){
        if(!insumoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com o ID " + id + " não encontrado");
        }
        insumoAtualizado.setId(id);
        return insumoRepository.save(insumoAtualizado);
    }

    public void deletarInsumo(Long id){
        if(!insumoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com o ID " + id + " não encontrado");
        }
        insumoRepository.deleteById(id);
    }
}


