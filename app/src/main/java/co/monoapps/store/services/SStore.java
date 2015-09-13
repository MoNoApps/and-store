package co.monoapps.store.services;

import java.util.List;

import co.monoapps.store.models.MCategoria;
import co.monoapps.store.models.MProducto;
import retrofit.http.GET;

public interface SStore {
    @GET("/open/productos")
    List<MProducto> getProducts();

    @GET("/open/categorias")
    List<MCategoria> getCategories();
}
