package fi.unju.edu.ar.tpfinal.Interfaces;

import fi.unju.edu.ar.tpfinal.Views.Login;

/**
 * Created by HSoft on 27/10/2017.
 */

public interface LoginInteractor {

    void validUser(String pass, LoginPresenter loginPresenter, Login login);

    Boolean userExist(LoginPresenter loginPresenter, Login login);

}
