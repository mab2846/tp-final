package fi.unju.edu.ar.tpfinal.Views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.sql.Date;

import fi.unju.edu.ar.tpfinal.Interfaces.ProductoPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.ProductoView;
import fi.unju.edu.ar.tpfinal.Models.Category;
import fi.unju.edu.ar.tpfinal.Models.Producto;
import fi.unju.edu.ar.tpfinal.Presenters.ProductoPresenterImp;
import fi.unju.edu.ar.tpfinal.R;

public class RegistroProducto extends AppCompatActivity implements ProductoView{
    private ProductoPresenter productoPresenter;
    private EditText nombre ;
    private EditText cantidad;
    private EditText unidad;
    private EditText precio;
    private EditText fecha;
    private EditText comercio;
    private EditText categoria;
    private ImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_producto);
        productoPresenter = new ProductoPresenterImp(this);
        nombre = (EditText)findViewById(R.id.txtNobreProd);
        cantidad = (EditText)findViewById(R.id.txtCantidad);
        unidad = (EditText)findViewById(R.id.txtUnidad);
        precio = (EditText)findViewById(R.id.txtPrecio);
        fecha = (EditText)findViewById(R.id.txtFecha);
        comercio =(EditText)findViewById(R.id.txtComrcio);
        categoria = (EditText)findViewById(R.id.txtCategoria);
        imagen=(ImageView) findViewById(R.id.imageProducto);

    }

    public void agregarProducto(View v){
        System.out.println("hola view");
        Category category = new Category();
        category.setName(categoria.getText().toString());

        Producto producto = new Producto();

        producto.setNombre(nombre.getText().toString());
        producto.setCantidad(Integer.valueOf(cantidad.getText().toString()));
        producto.setUnidad(unidad.getText().toString());
        producto.setPrecio(Double.valueOf(precio.getText().toString()));
        producto.setFechaCompra(fecha.getText().toString());
        producto.setCategoria(category);
        producto.setImagen(convertirImagen());
        producto.setComercio(categoria.getText().toString());

        productoPresenter.agregarProducto(producto,this);

        System.out.println("hola view");

    }



    public byte [] convertirImagen(){
        Bitmap bp = ((BitmapDrawable)imagen.getDrawable()).getBitmap();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bp.compress(Bitmap.CompressFormat.PNG,100,output);
        byte[] img = output.toByteArray();
        return img;
    }


    public void abrirGaleria(View V){
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        i.setType("image/");
        startActivityForResult(Intent.createChooser(i,"Seleccione la aplicacion"),10);
    }

    /**
     *
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Uri path = data.getData();
            imagen.setImageURI(path);
        }
    }

    @Override
    public void showErrorNombre() {
        nombre.setError("campo obligatorio");
    }

    @Override
    public void showErrorCantidad() {
        cantidad.setError("campo obligatorio");
    }

    @Override
    public void ShowErrorUnidad() {
        cantidad.setError("campo obligatorio");
    }

    @Override
    public void showErrorFecha() {
        fecha.setError("campo obligatorio");
    }

    public void moveraP(){
        startActivity(new Intent(RegistroProducto.this,MenuPrincipal.class));
    }
}
