package br.com.calderani.metrorecyclerviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.calderani.metrorecyclerviewer.api.APIUtils;
import br.com.calderani.metrorecyclerviewer.api.MetroAPI;
import br.com.calderani.metrorecyclerviewer.adapter.MetroAdapter;
import br.com.calderani.metrorecyclerviewer.model.Metro;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMetros;
    private MetroAdapter metroAdapter;
    private MetroAPI metroAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        metroAdapter = new MetroAdapter(new ArrayList<Metro>());

        rvMetros = (RecyclerView) findViewById(R.id.rvMetros);
        rvMetros.setLayoutManager(new LinearLayoutManager(this));
        rvMetros.setAdapter(metroAdapter);
        rvMetros.setHasFixedSize(true);
        /*rvMetros.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));*/
        carregarMetros();
    }

    private void carregarMetros() {
        metroAPI = APIUtils.getMetroAPIVersion();
        metroAPI.getLinhas().enqueue(new Callback<List<Metro>>() {
            @Override
            public void onResponse(Call<List<Metro>> call, Response<List<Metro>> response) {
                if(response.isSuccessful()) { // Sucesso
                    metroAdapter.update(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Metro>> call, Throwable t) {
                // Faio
                String errorMessage = t.getMessage();
            }
        });
    }
}
