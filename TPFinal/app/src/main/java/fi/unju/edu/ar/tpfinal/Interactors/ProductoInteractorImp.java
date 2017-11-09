package fi.unju.edu.ar.tpfinal.Interactors;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

import fi.unju.edu.ar.tpfinal.Interfaces.ProductoInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.ProductoPresenter;
import fi.unju.edu.ar.tpfinal.Models.Producto;
import fi.unju.edu.ar.tpfinal.OpenHelper.ProductSQLite;
import fi.unju.edu.ar.tpfinal.OpenHelper.SQLiteUtils;
import fi.unju.edu.ar.tpfinal.OpenHelper.UserSQLite;
import fi.unju.edu.ar.tpfinal.Views.MenuPrincipal;
import fi.unju.edu.ar.tpfinal.Views.RegistroProducto;

/**
 * Created by joel on 06/11/2017.
 */

public class ProductoInteractorImp implements ProductoInteractor {

    @Override
    public void agregarProducto(ProductoPresenter productoPresenter , Producto producto, RegistroProducto registroProducto) {
        ProductSQLite con = new ProductSQLite(registroProducto, SQLiteUtils.DB, null, 2);
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues val = new ContentValues();

        if(!producto.getNombre().isEmpty() && producto.getPrecio() > 0
                && !producto.getUnidad().isEmpty() && producto.getCantidad() > 0){
            val.put(SQLiteUtils.NOMBRE_PRO,producto.getNombre());
            val.put(SQLiteUtils.UNIDAD_PRO,producto.getUnidad());
            val.put(SQLiteUtils.CANTIDAD_PRO,producto.getCantidad());
            val.put(SQLiteUtils.PRECIO_PRO,producto.getPrecio());
            val.put(SQLiteUtils.FECHA_COMPRA_PRO,producto.getFechaCompra());
            val.put(SQLiteUtils.IMAGEN_PRO,producto.getImagen());
            val.put(SQLiteUtils.CATEGORIA_PRO, producto.getCategoria().getName());
            val.put(SQLiteUtils.COMRECIO_PRO,producto.getComercio());

            try {
                Long response = db.insert(SQLiteUtils.PRODUCTS,SQLiteUtils.ID_PRO,val);
                Toast.makeText(registroProducto.getApplicationContext(), "Producto agregado correctamente",Toast
                        .LENGTH_LONG).show();
                db.close();

            }catch (Exception e){

            }

        }else{

            if(producto.getNombre().isEmpty()){
                productoPresenter.showErrorNombre();
            }
            if(producto.getPrecio() <= 0){
//                productoPresenter.showErrorPrecio();
            }
            if(producto.getCantidad() <= 0){
                productoPresenter.showErrorCantidad();
            }
            if(producto.getUnidad().isEmpty()){
                productoPresenter.ShowErrorUnidad();
            }

        }

    }

    @Override
    public ArrayList buscarProducto(MenuPrincipal menuPrincipal) {

        ArrayList<String> lista = new ArrayList<>();

        UserSQLite conexion = new UserSQLite(menuPrincipal, SQLiteUtils.DB, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        String query = "SELECT * FROM productos";
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do {
                lista.add(cursor.getString(0) + " " + cursor.getString(1));
            }while (cursor.moveToNext());
        }

        return lista;
    }


}
