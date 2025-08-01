package com.jayjayAI.MixAnalytics.Service;

import com.jayjayAI.MixAnalytics.Model.InsumoModel;
import com.jayjayAI.MixAnalytics.Repository.InsumoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {

    private InsumoRepository insumoRepository;

    public InsumoService(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    public List<InsumoModel> listar(){
        return insumoRepository.findAll();
    }

    public InsumoModel cadastrarInsumo(InsumoModel insumoModel){
        return insumoRepository.save(insumoModel);
    }

    public Optional<InsumoModel> listarPorId(long id){
        return insumoRepository.findById(id);
    }

    public InsumoModel atualizarInsumo(Long id, InsumoModel insumoAtualizado){
        Optional<InsumoModel> insumoExistence = insumoRepository.findById(id);
        if (insumoExistence.isPresent()){
            insumoAtualizado.setId(id);
            insumoRepository.save(insumoAtualizado);
            return insumoAtualizado;
        } else {
            return null;
        }
    }

    public void deletarInsumo(Long id){
        insumoRepository.deleteById(id);
    }
}


