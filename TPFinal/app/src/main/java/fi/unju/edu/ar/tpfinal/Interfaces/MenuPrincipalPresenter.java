package fi.unju.edu.ar.tpfinal.Interfaces;

import android.database.Cursor;

import java.util.ArrayList;

import fi.unju.edu.ar.tpfinal.Models.Producto;
import fi.unju.edu.ar.tpfinal.Views.MenuPrincipal;

/**
 * Created by joel on 08/11/2017.
 */

public interface MenuPrincipalPresenter {
    ArrayList<Producto> mostrarProducto(MenuPrincipal menuPrincipal);
}
