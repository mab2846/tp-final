package fi.unju.edu.ar.tpfinal.Interfaces;

import fi.unju.edu.ar.tpfinal.Views.Categoria;

/**
 * Created by mabel on 8/11/2017.
 */

public interface CategoriaPresenter {
    void showErrorNombre();
    void backMenu();
    void agregar(String nombre, Categoria categoria);
}