package fi.unju.edu.ar.tpfinal.Interactors;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import fi.unju.edu.ar.tpfinal.Interfaces.CategoriaInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.CategoriaPresenter;
import fi.unju.edu.ar.tpfinal.OpenHelper.CategorySQLite;
import fi.unju.edu.ar.tpfinal.OpenHelper.SQLiteUtils;
import fi.unju.edu.ar.tpfinal.Views.Categoria;

/**
 * Created by mabel on 8/11/2017.
 */

public class CategoriaInteractorImpl implements CategoriaInteractor{



    @Override
    public void agregar(String nombre, Categoria categoria, CategoriaPresenter categoriaPresenter) {
        if (!nombre.isEmpty()) {
            CategorySQLite con = new CategorySQLite(categoria,SQLiteUtils.DB,null,1);
            ContentValues val = new ContentValues();
            SQLiteDatabase db = con.getWritableDatabase();

            try {
                Long response = db.insert(SQLiteUtils.CATEGORIES,SQLiteUtils.ID_CAT,val);
                Toast.makeText(categoria.getApplicationContext(), "Categoria agregado correctamente",Toast
                        .LENGTH_LONG).show();
                db.close();
                categoriaPresenter.backMenu();


            }catch (Exception e){
            System.out.print(e);
            }
        }else {
            categoriaPresenter.showErrorNombre();
        }
        }

}

