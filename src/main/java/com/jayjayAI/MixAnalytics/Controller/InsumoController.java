package com.jayjayAI.MixAnalytics.Controller;

import com.jayjayAI.MixAnalytics.Model.InsumoModel;
import com.jayjayAI.MixAnalytics.Service.InsumoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/insumo")
public class InsumoController {

    private InsumoService insumoService;

    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarInsumo(@RequestBody InsumoModel insumoModel){
        InsumoModel insumoSalvo = insumoService.cadastrarInsumo(insumoModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Insumo de nome " + insumoModel.getName() + " de id " + insumoModel.getId() + " criado com sucesso");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<InsumoModel>> listar(){
         List<InsumoModel> insumoList = insumoService.listar();
         return ResponseEntity.ok(insumoList);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarInsumo (@PathVariable Long id, @RequestBody InsumoModel insumoAtualizado){
        InsumoModel insumoAtualizadoConfirmado = insumoService.atualizarInsumo(id,insumoAtualizado);
        if(insumoAtualizadoConfirmado != null ){
            return ResponseEntity.ok(insumoAtualizado);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("insumo do ID " + id + " não encontrado");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarInsumo(@PathVariable Long id){
        insumoService.deletarInsumo(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body("insumo deletado com sucesso");
    }
}
