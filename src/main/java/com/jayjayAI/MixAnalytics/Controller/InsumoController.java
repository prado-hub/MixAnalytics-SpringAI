package com.jayjayAI.MixAnalytics.Controller;

import com.jayjayAI.MixAnalytics.Exceptions.RecursoNaoEncontradoException;
import com.jayjayAI.MixAnalytics.Model.InsumoModel;
import com.jayjayAI.MixAnalytics.Service.InsumoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/insumo")
public class InsumoController {

    private final InsumoService insumoService;

    public InsumoController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @PostMapping("/cadastrar")
    @Operation(summary = "Cadastra um insumo no sistema",description = "rota insire o atributos desejados e cadastra no db")
    public ResponseEntity<String> cadastrarInsumo(@RequestBody InsumoModel insumoModel){
        InsumoModel insumoSalvo = insumoService.cadastrarInsumo(insumoModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Insumo de nome " + insumoModel.getName() + " de id " + insumoModel.getId() + " criado com sucesso");
    }

    @GetMapping("/listar")
    @Operation(summary = "Lista todos os insumos cadastrados no sistema",description = "rota lista todos os insumos inseridos no db")
    public ResponseEntity<List<InsumoModel>> listar(){
         List<InsumoModel> insumoList = insumoService.listar();
         return ResponseEntity.ok(insumoList);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "lista o insumo por id", description = "rota lista os atributos do insumo por id")
    public ResponseEntity<InsumoModel> listarPorId(@PathVariable Long id){
        InsumoModel insumoModel = insumoService.listarPorId(id);
        return ResponseEntity.ok(insumoModel);
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualiza o insumo por id",description = "rota atualiza os atributos do seu insumo por id")
    public ResponseEntity<?> atualizarInsumo (@PathVariable Long id, @RequestBody InsumoModel insumoAtualizado){
            InsumoModel insumoAtualizadoConfirmado = insumoService.atualizarInsumo(id, insumoAtualizado);
            return ResponseEntity.ok(insumoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta o insumo por id",description = "rota deleta insumo inserido no db por id")
    public ResponseEntity<String> deletarInsumo(@PathVariable Long id){
            insumoService.deletarInsumo(id);
            return ResponseEntity.noContent().build();
    }
}
