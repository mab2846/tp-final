package fi.unju.edu.ar.tpfinal.OpenHelper;

/**
 * Created by HSoft on 1/11/2017.
 */

public class SQLiteUtils {

    public static final String DB = "DB_LIST";

    /**
     * Utils de tabla user
     */

    public static final String USER_TABLE = "CREATE TABLE users (id_user INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, username TEXT,name TEXT, mail TEXT, password TEXT)";

    public static final String USERNAME = "username";

    public static final String NAME = "name";

    public static final String MAIL = "mail";

    public static final String PASSWORD = "password";

    public static final String GET_USER = "SELECT * FROM users";

    /**
     * Utils de tabla products
     */
    public static final String PRODUCTS_TABLE = "CREATE TABLE products (id_product INTEGER PRIMARY KEY " +
            "AUTOINCREMENT, nombre TEXT, unidad TEXT, cantidad INTEGER, precio REAL, fechaCompra TEXT, " +
            "categoria TEXT, imagen BLOB, comercio TEXT)";

    public static final String PRODUCTS = "products";
    public static final String ID_PRO = "id_product";
    public static final String NOMBRE_PRO = "nombre";
    public static final String UNIDAD_PRO = "unidad";
    public static final String CANTIDAD_PRO = "cantidad";
    public static final String PRECIO_PRO = "precio";
    public static final String FECHA_COMPRA_PRO = "fechaCompra";
    public static final String CATEGORIA_PRO = "categoria";
    public static final String IMAGEN_PRO = "imagen";
    public static final String COMRECIO_PRO = "comercio";


    /**
     * Utils de tabla categories
     */

    public static final String CATEGORIES_TABLE = "CREATE TABLE categories(id_category INTEGER PRIMARY KEY" +
            "AUTOINCREMENT, name TEXT)";
    public  static final  String CATEGORIES = "categories";
    public static final String ID_CAT= "id_category";

}
