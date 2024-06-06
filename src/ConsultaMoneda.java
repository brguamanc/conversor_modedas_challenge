import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public MonedaDTO consultarMoneda(int opcion) {
        var codigo = new String();
        var apiKey = "cb0bb34af41636eb0823502f";

        if (opcion == 1 || opcion == 3 || opcion == 5) {
            codigo = "USD";
        } else if (opcion == 2 ) {
            codigo= "ARS";
        } else if (opcion ==4) {
            codigo ="BRL";
        }else if (opcion ==6) {
            codigo ="COP";
        }

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ apiKey+"/latest/"+codigo);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), MonedaDTO.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error en obtener datos");
        }
    }
}
