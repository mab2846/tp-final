package fi.unju.edu.ar.tpfinal.Presenters;

import fi.unju.edu.ar.tpfinal.Interactors.RegistroInteractorImpl;
import fi.unju.edu.ar.tpfinal.Interfaces.RegistroInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.RegistroPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.RegistroView;
import fi.unju.edu.ar.tpfinal.Views.Registro;

/**
 * Created by Gisela on 01/11/2017.
 */

public class RegistroPresenterImpl implements RegistroPresenter {

    private RegistroView registroView;
    private RegistroInteractor registroInteractor;

    public RegistroPresenterImpl(RegistroView registroview) {
        this.registroView = registroview;
        registroInteractor = new RegistroInteractorImpl();
    }

    @Override
    public void agregarUsuario(String user, String name, String mail, String pass, Registro registro) {
        registroInteractor.agragarUsuario(user,name,mail,pass,this,registro);
    }

    @Override
    public void setErrorUser() {
        if(registroView != null){
            registroView.setErrorUser();
        }
    }

    @Override
    public void setErrorName() {
        if(registroView != null){
            registroView.setErrorName();
        }
    }

    @Override
    public void setErrorMail() {
        if(registroView != null){
            registroView.setErrorMail();
        }
    }

    @Override
    public void setErrorPass() {
        if(registroView != null){
            registroView.setErrorPass();
        }
    }

    @Override
    public void login() {
        if(registroView != null){
            registroView.navigatePrincipal();
        }
    }

}
