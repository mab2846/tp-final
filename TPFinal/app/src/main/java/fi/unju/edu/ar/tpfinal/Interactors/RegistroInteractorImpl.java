package fi.unju.edu.ar.tpfinal.Interactors;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import fi.unju.edu.ar.tpfinal.Interfaces.RegistroInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.RegistroPresenter;
import fi.unju.edu.ar.tpfinal.OpenHelper.SQLiteUtils;
import fi.unju.edu.ar.tpfinal.OpenHelper.UserSQLite;
import fi.unju.edu.ar.tpfinal.Views.Registro;

/**
 * Created by HSoft on 1/11/2017.
 */

public class RegistroInteractorImpl implements RegistroInteractor {
    @Override
    public void agragarUsuario(String user, String name, String mail, String pass,
                               RegistroPresenter registroPresenter, Registro registro) {

        UserSQLite conexion = new UserSQLite(registro, SQLiteUtils.DB,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues values = new ContentValues();
        if (!user.equals("") && !name.equals("") && !mail.equals("") && !pass.equals("")) {
            values.put(SQLiteUtils.USERNAME,user);
            values.put(SQLiteUtils.NAME,name);
            values.put(SQLiteUtils.MAIL,mail);
            values.put(SQLiteUtils.PASSWORD,pass);

            try {
                Long idResultante = db.insert("users","id_user",values);
                Toast.makeText(registro.getApplicationContext(), "Usuario agregado correctamente",Toast
                        .LENGTH_LONG).show();
                db.close();
                registroPresenter.login();
            }catch (Exception e){

            }
        }else{
            if (user.equals(""))
                registroPresenter.setErrorUser();
            if (name.equals(""))
                registroPresenter.setErrorName();
            if (mail.equals(""))
                registroPresenter.setErrorMail();
            if (pass.equals(""))
                registroPresenter.setErrorPass();

        }

    }
}
