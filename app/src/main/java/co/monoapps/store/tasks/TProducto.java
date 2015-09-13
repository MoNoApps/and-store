package co.monoapps.store.tasks;

import android.os.AsyncTask;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.sql.Date;
import java.util.List;

import co.monoapps.store.StoreApp;
import co.monoapps.store.models.MProducto;
import co.monoapps.store.services.SDeserializer;
import co.monoapps.store.services.SStore;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class TProducto extends AsyncTask<String, Integer, List<MProducto>> {

    @Override
    protected List<MProducto> doInBackground(String... params) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .registerTypeAdapter(MProducto.class, new SDeserializer<MProducto>())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(StoreApp.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();

        SStore service = restAdapter.create(SStore.class);
        return service.getProducts();
    }

    @Override
    protected void onPostExecute(List<MProducto> o) {
        super.onPostExecute(o);
    }
}