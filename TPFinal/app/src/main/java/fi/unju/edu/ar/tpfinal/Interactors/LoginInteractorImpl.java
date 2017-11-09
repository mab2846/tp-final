package fi.unju.edu.ar.tpfinal.Interactors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import fi.unju.edu.ar.tpfinal.Interfaces.LoginInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.LoginPresenter;
import fi.unju.edu.ar.tpfinal.OpenHelper.SQLiteUtils;
import fi.unju.edu.ar.tpfinal.OpenHelper.UserSQLite;
import fi.unju.edu.ar.tpfinal.Views.Login;

/**
 * Created by HSoft on 27/10/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {


    @Override
    public void validUser(String pass, LoginPresenter loginPresenter, Login login) {
        try {
            if(!pass.equals("")){
                UserSQLite conexion = new UserSQLite(login, SQLiteUtils.DB, null, 1);
                SQLiteDatabase db = conexion.getReadableDatabase();

                String[] parametros = {pass};
                String[] campos = {SQLiteUtils.USERNAME,SQLiteUtils.PASSWORD};
                Cursor cursor = db.query("users",campos,"password = ?",parametros,null,null,null);
                cursor.moveToFirst();

                if(cursor.getString(1).equals(pass)){
                    loginPresenter.login();
                }else{
                    loginPresenter.showErrorPassLog();
                }

            }else {
                if(pass.equals("")){
                    loginPresenter.showErrorPass();
                }
            }
        }catch (Exception e){
            loginPresenter.showErrorPassLog();
        }
    }

    @Override
    public Boolean userExist(LoginPresenter loginPresenter, Login login) {
        UserSQLite conexion = new UserSQLite(login, SQLiteUtils.DB, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

        try {
            Cursor cursor = db.rawQuery(SQLiteUtils.GET_USER,null);
            cursor.moveToFirst();

            if(cursor.getString(1).equals("")){
                return true;
            }else{
                return false;
            }

        }catch (Exception e){
            return true;
        }
    }
}
