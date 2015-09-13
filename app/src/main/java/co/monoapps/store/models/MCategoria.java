package co.monoapps.store.models;

public class MCategoria {

    public String  _id;
    public String  nombre;
    public String  userId;
    public Integer createdAt;

    @Override
    public String toString(){
        return nombre;
    }

}