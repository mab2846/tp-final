package fi.unju.edu.ar.tpfinal.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import fi.unju.edu.ar.tpfinal.Interfaces.CategoriaPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.CategoriaView;
import fi.unju.edu.ar.tpfinal.Presenters.CategoriaPresenterImpl;
import fi.unju.edu.ar.tpfinal.R;

public class Categoria extends AppCompatActivity  implements CategoriaView {
    private EditText nombre;
    private CategoriaPresenter categoriaPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        
        nombre = (EditText) findViewById(R.id.txtNobreCate);
        categoriaPresenter = new CategoriaPresenterImpl(this);
    }

    @Override
    public void showErrorNombre() {
        nombre.setError("complete campo");

    }

    @Override
    public void backMenu() {
        startActivity(new Intent(this, MenuPrincipal.class));
    }

    @Override
    public void agregar(View v) {
        categoriaPresenter.agregar(nombre.getText().toString(), this);
    }
}