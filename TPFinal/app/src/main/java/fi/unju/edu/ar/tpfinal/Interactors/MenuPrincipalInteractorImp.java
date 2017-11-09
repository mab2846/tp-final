package fi.unju.edu.ar.tpfinal.Interactors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fi.unju.edu.ar.tpfinal.Interfaces.MenuPrincipalInteractor;
import fi.unju.edu.ar.tpfinal.Models.Producto;
import fi.unju.edu.ar.tpfinal.OpenHelper.SQLiteUtils;
import fi.unju.edu.ar.tpfinal.OpenHelper.UserSQLite;
import fi.unju.edu.ar.tpfinal.Views.MenuPrincipal;

/**
 * Created by joel on 08/11/2017.
 */

public class MenuPrincipalInteractorImp implements MenuPrincipalInteractor {
    @Override
    public ArrayList<Producto> mostrarProductos(MenuPrincipal menuPrincipal) {
        ArrayList<Producto> lista = new ArrayList<>();
        Producto producto = new Producto();
        UserSQLite conexion = new UserSQLite(menuPrincipal, SQLiteUtils.DB, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        String query = "SELECT * FROM productos";
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                lista.add(new Producto(null,cursor.getString(1),cursor.getString(2),null,cursor.getDouble(4),cursor.getString(6),null,
                        null,null));
            }while (!cursor.isLast());
        }
        return lista;
    }
}
