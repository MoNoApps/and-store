package co.monoapps.store.models;

public class MProducto {

    public String  _id;
    public String  nombre;
    public String  userId;
    public String  imagen;
    public String  categoria;
    public String  codigo;
    public String  comentario;
    public Integer precio;
    public Integer unidades;
    public Integer createdAt;

    @Override
    public String toString(){
        return nombre;
    }

}