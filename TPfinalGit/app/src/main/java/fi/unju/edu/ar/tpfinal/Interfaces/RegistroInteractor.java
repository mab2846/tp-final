package fi.unju.edu.ar.tpfinal.Interfaces;

import fi.unju.edu.ar.tpfinal.Views.Registro;

/**
 * Created by HSoft on 1/11/2017.
 */

public interface RegistroInteractor {

    public void agragarUsuario(String user, String name, String mail, String pass,
                               RegistroPresenter registroPresenter, Registro registro);

}
