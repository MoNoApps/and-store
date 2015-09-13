package co.monoapps.store;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import co.monoapps.store.models.MProducto;

public class StoreApp extends Application {

    public final static String BASE_URL = "http://store.monoapps.co/api";
    private List<MProducto> wrines = new ArrayList<>();
    public MProducto item;

    public List<MProducto> getWrines() {
        return wrines;
    }

    public MProducto getItem() {
        return item;
    }

    public void setItem(MProducto item) {
        this.item = item;
    }

}
