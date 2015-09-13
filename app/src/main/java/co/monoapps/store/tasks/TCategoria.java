package co.monoapps.store.tasks;

import android.os.AsyncTask;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.sql.Date;
import java.util.List;

import co.monoapps.store.StoreApp;
import co.monoapps.store.models.MCategoria;
import co.monoapps.store.models.MProducto;
import co.monoapps.store.services.SDeserializer;
import co.monoapps.store.services.SStore;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class TCategoria extends AsyncTask<String, Integer, List<MCategoria>> {

    @Override
    protected List<MCategoria> doInBackground(String... params) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .registerTypeAdapter(MProducto.class, new SDeserializer<MCategoria>())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(StoreApp.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();

        SStore service = restAdapter.create(SStore.class);
        return service.getCategories();
    }

    @Override
    protected void onPostExecute(List<MCategoria> o) {
        super.onPostExecute(o);
    }
}