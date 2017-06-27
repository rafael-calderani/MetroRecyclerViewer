package br.com.calderani.metrorecyclerviewer.API;

import java.util.List;

import br.com.calderani.metrorecyclerviewer.Model.Metro;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by logonrm on 26/06/2017.
 */

public interface MetroAPI {
    @GET("/linhas")
    Call<List<Metro>> getLinhas();
}
