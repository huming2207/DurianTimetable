package helpers;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;

import java.io.IOException;

public class HttpFetcher
{
    public static String fetch(OkHttpClient httpClient, Request request, Logger logger)
    {
        try {
            Response response = httpClient.newCall(request).execute();
            if(!response.isSuccessful()) throw new IOException("Unexpected response received: " + response);
            if(response.body() == null ||
                    response.body().string().isEmpty()) throw new IOException("Empty body received: " + response);
            return response.body().string();
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
