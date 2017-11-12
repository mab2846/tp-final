package fi.unju.edu.ar.tpfinal.Views;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import fi.unju.edu.ar.tpfinal.Models.Producto;
import fi.unju.edu.ar.tpfinal.R;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.widget.TextView;
import android.support.v7.widget.SearchView;
import android.support.v4.view.MenuItemCompat;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//import fi.unju.edu.ar.tpfinal.R;
public class MenuPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,OnQueryTextListener, OnActionExpandListener{
    private Categoria categoria = new Categoria();
    private EditText etAsunto;
    private TextView texto;

    //temporal
    public List<Producto> productos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        texto = (TextView) findViewById(R.id.texto);
        productos.add(new Producto(1, "gelatina", null, 3, 20.0, null, null, null, null));
        productos.add(new Producto(1, "galletas", null, 4, 25.0, null, null, null, null));
        productos.add(new Producto(1, "arroz", null, 6, 30.0, null, null, null, null));
        productos.add(new Producto(1, "cafe", null, 3, 50.0, null, null, null, null));
        productos.add(new Producto(1, "leche", null, 7, 100.0, null, null, null, null));
        productos.add(new Producto(1, "azucar", null, 3, 20.0, null, null, null, null));
        productos.add(new Producto(1, "naranja", null, 3, 20.0, null, null, null, null));
        productos.add(new Producto(1, "naranja", null, 3, 20.0, null, null, null, null));



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);


        MenuItem searchItem = menu.findItem(R.id.menu3_buscar);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(searchItem, this);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            // Handle the camera action
        }else if (id == R.id.crearProd){

            startActivity(new Intent(this,RegistroProducto.class));
        }else if (id == R.id.crearCate){
            //LayoutInflater inflater = getLayoutInflater();

            //View dialoglayout = inflater.inflate(R.layout.activity_categoria, null);
            //sunto = (EditText) dialoglayout.findViewById(R.id.txtNobreCate);
            //Button btnAgregar = (Button) dialoglayout.findViewById(R.id.btnAgregarProducto);

            //btnAgregar.setOnClickListener(new View.OnClickListener() {
             //   @Override
             //   public void onClick(View view) {

              // }
            //});


            //AlertDialog.Builder builder = new AlertDialog.Builder(MenuPrincipal.this);
            //builder.setView(dialoglayout);
            //builder.show();
            //startActivity(new Intent(this,Categoria.class));
            startActivity(new Intent(this,Categoria.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        Toast.makeText(getApplicationContext(), "EXxpandir", Toast.LENGTH_SHORT).show();
        return true;

    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Colapsar", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        //texto.setText("Texto a buscar\n\n" + s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

            //texto.setText("Buscando...\n\n" + s );
        mostrar(s);

        return true;
    }

    public void mostrar (String s){
        for (Producto p:productos){

            if (s.equals(p.getNombre())){
                texto.setText("nombre:"+p.getNombre()+"cantidad:"+p.getCantidad()+"\n\n" +"precio:"+p.getPrecio()+"\n\n");
                break;
            }else{
                texto.setText("Buscando..");
            }
        }



    }



    //public void agregar(View v) {
     //   categoria.setNombre(etAsunto);
     //   categoria.agregar(v);
   // }

    }

