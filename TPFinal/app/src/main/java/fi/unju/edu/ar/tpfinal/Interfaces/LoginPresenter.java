package fi.unju.edu.ar.tpfinal.Interfaces;

import fi.unju.edu.ar.tpfinal.Views.Login;

/**
 * Created by HSoft on 27/10/2017.
 */

public interface LoginPresenter {
    void validarUsuario(String pass,Login login);
    void showErrorPass();
    void showErrorPassLog();
    void login();
    Boolean userExist(Login login);
}
