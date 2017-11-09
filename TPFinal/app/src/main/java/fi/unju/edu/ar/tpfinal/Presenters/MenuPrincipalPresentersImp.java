package fi.unju.edu.ar.tpfinal.Presenters;

import android.database.Cursor;

import java.util.ArrayList;

import fi.unju.edu.ar.tpfinal.Interactors.MenuPrincipalInteractorImp;
import fi.unju.edu.ar.tpfinal.Interfaces.MenuPrincipalInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.MenuPrincipalPresenter;
import fi.unju.edu.ar.tpfinal.Models.Producto;
import fi.unju.edu.ar.tpfinal.Views.MenuPrincipal;
import fi.unju.edu.ar.tpfinal.Views.ProductoFragment;

/**
 * Created by joel on 08/11/2017.
 */

public class MenuPrincipalPresentersImp implements MenuPrincipalPresenter {
    private MenuPrincipal menuPrincipal;
    private MenuPrincipalInteractor menuPrincipalInteractor;

    public MenuPrincipalPresentersImp(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        menuPrincipalInteractor = new MenuPrincipalInteractorImp();
    }
    public MenuPrincipalPresentersImp(ProductoFragment productoFragment) {


    }


    @Override
    public ArrayList<Producto> mostrarProducto(MenuPrincipal menuPrincipal) {
       return menuPrincipalInteractor.mostrarProductos(menuPrincipal);
    }
}
