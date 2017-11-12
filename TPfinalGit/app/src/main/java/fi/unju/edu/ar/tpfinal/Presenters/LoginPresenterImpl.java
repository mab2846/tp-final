package fi.unju.edu.ar.tpfinal.Presenters;

import fi.unju.edu.ar.tpfinal.Interactors.LoginInteractorImpl;
import fi.unju.edu.ar.tpfinal.Interfaces.LoginInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.LoginPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.LoginView;
import fi.unju.edu.ar.tpfinal.Views.Login;

/**
 * Created by HSoft on 27/10/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        loginInteractor = new LoginInteractorImpl();
    }


    @Override
    public void validarUsuario(String pass,Login login) {

        if(loginView != null){
            loginInteractor.validUser(pass,this,login);
        }


    }

    @Override
    public void showErrorPass() {
        if(loginView != null){
            loginView.showErrorPass();
        }
    }

    @Override
    public void showErrorPassLog() {
        if(loginView != null){
            loginView.showErrorPassLog();
        }
    }

    @Override
    public void login() {
        if(loginView != null){
            loginView.navigatePrincipal();
        }
    }

    @Override
    public Boolean userExist(Login login) {
        return loginInteractor.userExist(this,login);
    }
}
