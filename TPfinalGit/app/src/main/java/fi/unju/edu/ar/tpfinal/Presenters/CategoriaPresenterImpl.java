package fi.unju.edu.ar.tpfinal.Presenters;

import fi.unju.edu.ar.tpfinal.Interactors.CategoriaInteractorImpl;
import fi.unju.edu.ar.tpfinal.Interfaces.CategoriaInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.CategoriaPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.CategoriaView;
import fi.unju.edu.ar.tpfinal.Views.Categoria;

/**
 * Created by mabel on 8/11/2017.
 */

public class CategoriaPresenterImpl implements CategoriaPresenter {
    private CategoriaView categoriaView;
    private CategoriaInteractor categoriaInteractor;

    public CategoriaPresenterImpl(CategoriaView categoriaView) {
        this.categoriaView = categoriaView;
        categoriaInteractor= new CategoriaInteractorImpl();
    }

    @Override
    public void showErrorNombre() {
        if(categoriaView != null){
            categoriaView.showErrorNombre();
        }
    }

    @Override
    public void backMenu() {
        if(categoriaView != null){
            categoriaView.backMenu();
        }
    }

    @Override
    public void agregar( String nombre , Categoria categoria) {
        categoriaInteractor.agregar(nombre, categoria,this);
    }
}
