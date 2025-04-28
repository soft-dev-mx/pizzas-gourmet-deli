package com.ampeliodev.pizzasgourmetdeliapirest.service.serviceclip;

import com.ampeliodev.pizzasgourmetdeliapirest.dto.clip.DtoPagoClip;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public class ServicioPagoClip {

    @Value("${clip.api.token}")
    private String clipApiToken;

    @Value("${clip.api.url}")
    private String clipApiUrl;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String crearOrdenPago(DtoPagoClip request) throws Exception {

        Map<String, Object> bodyMap = Map.of(
                "amount", request.getImporteTotal(),
                "currency", "MXN",
                "purchase_description", "ejemplo de compra",
                "redirection_url", Map.of(
                        "success", "https://soft-dev-mx.com/clientes-pedidos/pagina-inicio",
                        "error", "https://soft-dev-mx.com/clientes-pedidos/pagina-inicio",
                        "default", "https://soft-dev-mx.com/clientes-pedidos/pagina-inicio"
                )
        );

        String bodyJson = objectMapper.writeValueAsString(bodyMap);

        HttpRequest httpRequest = HttpRequest.newBuilder()

                .uri(URI.create(clipApiUrl))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic " + clipApiToken)
                .POST(HttpRequest.BodyPublishers.ofString(bodyJson))
                .build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200 || response.statusCode() == 201) {
            Map<String, Object> responseMap = objectMapper.readValue(response.body(), Map.class);
            return responseMap.get("status").toString();
        }else {
            throw new RuntimeException("Error al crear la orden: " + response.body());
        }
    }

}
