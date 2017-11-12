package fi.unju.edu.ar.tpfinal.Presenters;


import fi.unju.edu.ar.tpfinal.Interactors.ProductoInteractorImp;
import fi.unju.edu.ar.tpfinal.Interfaces.ProductoInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.ProductoPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.ProductoView;
import fi.unju.edu.ar.tpfinal.Models.Producto;
import fi.unju.edu.ar.tpfinal.Views.RegistroProducto;

/**
 * Created by joel on 06/11/2017.
 */

public class ProductoPresenterImp implements ProductoPresenter{
    private ProductoView productoView;
    private ProductoInteractor productoInteractor;

    public ProductoPresenterImp(ProductoView productoView) {
        this.productoView = productoView;
        productoInteractor = new ProductoInteractorImp();
    }

    @Override
    public void agregarProducto(Producto producto, RegistroProducto registroProducto) {

        productoInteractor.agregarProducto(this,producto,registroProducto);
        System.out.println("hola presenter");
    }

    @Override
    public void showErrorNombre() {
        productoView.showErrorNombre();
    }

    @Override
    public void showErrorCantidad() {

    }

    @Override
    public void ShowErrorUnidad() {

    }

    @Override
    public void showErrorFecha() {

    }
}
