package br.com.calderani.metrorecyclerviewer.API;

/**
 * Created by logonrm on 26/06/2017.
 */

public class APIUtils {
    public static final String BASE_URL = "http://10.3.1.19:3000/";

    public static MetroAPI getMetroAPIVersion() {
        return RetrofitClient.getClient(BASE_URL)
                .create(MetroAPI.class);
    }
}
