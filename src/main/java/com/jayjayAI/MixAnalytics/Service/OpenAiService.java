package com.jayjayAI.MixAnalytics.Service;

import com.jayjayAI.MixAnalytics.Model.InsumoModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpenAiService {

    private final ChatClient openAiChatModel;

    public OpenAiService(ChatClient.Builder openAiChatModelBuider) {
        this.openAiChatModel = openAiChatModelBuider.build();
    }

    public Mono<String> gerarReceita(List<InsumoModel> insumoModelList ){
        String insumos = insumoModelList.stream()
                .map(insumo -> String.format("insumo %s", insumo.getName()))
                .collect(Collectors.joining("\n"));

        return Mono.fromSupplier(() -> openAiChatModel
                .prompt("Me indique receitas de drink com base nessa lista de insumos" + insumos)
                .call()
                .content()
        );
    }
}
