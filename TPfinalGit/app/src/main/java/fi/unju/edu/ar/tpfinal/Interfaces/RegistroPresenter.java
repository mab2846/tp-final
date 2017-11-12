package fi.unju.edu.ar.tpfinal.Interfaces;

import fi.unju.edu.ar.tpfinal.Views.Registro;

/**
 * Created by HSoft on 1/11/2017.
 */

public interface RegistroPresenter {
    void agregarUsuario(String user, String name, String mail, String pass, Registro registro);

    void setErrorUser();
    void setErrorName();
    void setErrorMail();
    void setErrorPass();
    void login();
}
