package com.jayjayAI.MixAnalytics.Controller;

import com.jayjayAI.MixAnalytics.Model.InsumoModel;
import com.jayjayAI.MixAnalytics.Service.OpenAiService;
import com.jayjayAI.MixAnalytics.Service.InsumoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    private final InsumoService insumoService;
    private final OpenAiService openAiService;

    public ReceitaController(OpenAiService openAiService, InsumoService insumoService) {
        this.openAiService = openAiService;
        this.insumoService = insumoService;
    }

    @GetMapping("/gerar")
    @Operation(summary = "Gerar um drink",description = "geração de um drink com base em todos os insumos cadastrados")
    public Mono<ResponseEntity<String>> gerarReceita(){
        List<InsumoModel> insumoModelList = insumoService.listar();
        return openAiService.gerarReceita(insumoModelList)
                .map(recipe-> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}
