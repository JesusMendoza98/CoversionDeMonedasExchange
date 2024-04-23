import com.google.gson.*;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsultaApiExchange {
    public CurrencyCodeObject buscaTipoDivisa(String tipoDeDivisa) {
// Making Request

        String url_str = "https://v6.exchangerate-api.com/v6/bad41525f50e2d7456779476/latest/"+tipoDeDivisa;
        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to JSON //
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();


            return gson.fromJson(jsonobj.get("conversion_rates"), CurrencyCodeObject.class);





        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
return null;

    }
}
