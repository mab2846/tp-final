package fi.unju.edu.ar.tpfinal.Interfaces;

import android.database.Cursor;

import java.util.ArrayList;

import fi.unju.edu.ar.tpfinal.Models.Producto;
import fi.unju.edu.ar.tpfinal.Views.MenuPrincipal;
import fi.unju.edu.ar.tpfinal.Views.RegistroProducto;

/**
 * Created by joel on 06/11/2017.
 */

public interface ProductoInteractor {
    void agregarProducto(ProductoPresenter productoPresenter ,Producto producto, RegistroProducto registroProducto);
    ArrayList buscarProducto(MenuPrincipal menuPrincipal);
}
