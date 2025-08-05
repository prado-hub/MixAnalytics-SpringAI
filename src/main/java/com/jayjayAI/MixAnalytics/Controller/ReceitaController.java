package com.jayjayAI.MixAnalytics.Controller;

import com.jayjayAI.MixAnalytics.Model.InsumoModel;
import com.jayjayAI.MixAnalytics.Service.OpenAiService;
import com.jayjayAI.MixAnalytics.Service.InsumoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

    private InsumoService insumoService;
    private OpenAiService openAiService;

    public ReceitaController(OpenAiService openAiService, InsumoService insumoService) {
        this.openAiService = openAiService;
        this.insumoService = insumoService;
    }

    @GetMapping("/gerar")
    public Mono<ResponseEntity<String>> gerarReceita(){

        List<InsumoModel> insumoModelList = insumoService.listar();
        return openAiService.gerarReceita(insumoModelList)
                .map(recipe-> ResponseEntity.ok(recipe))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}
