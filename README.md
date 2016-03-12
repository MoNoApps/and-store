# and-store
Store For Android

## info
This is the android version for Store.

## configuration
replace BASE_URL with your API URL in StoreApp.java
````java
    public final static String BASE_URL = "http://myapp.mydomain/api";
````
## what is this for
This app is to expose public info about products and catalogs. For that reason there is not need to add login or store tokens in this version.

## model
Have in count that 'open' means if is public or no.

````json
    "categorias": {
      "admin": true,
      "param": "categoria",
      "clean": {},
      "schema": {
        "nombre": 1,
        "open": 1
      }
    },
    "productos": {
      "admin": true,
      "param": "producto",
      "clean": {},
      "schema": {
        "nombre": 1,
        "categoria": 1,
        "codigo": 1,
        "precio": 1,
        "tallas": 1,
        "imagen": 1,
        "unidades": 1,
        "comentario": 1,
        "open": 1
      }
    }
````
