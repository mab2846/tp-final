package fi.unju.edu.ar.tpfinal.Views;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

import fi.unju.edu.ar.tpfinal.Interactors.MenuPrincipalInteractorImp;
import fi.unju.edu.ar.tpfinal.Interfaces.MenuPrincipalInteractor;
import fi.unju.edu.ar.tpfinal.Interfaces.MenuPrincipalPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.ProductoPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.ProductoView;
import fi.unju.edu.ar.tpfinal.Models.AdapterProducto;
import fi.unju.edu.ar.tpfinal.Models.Producto;
import fi.unju.edu.ar.tpfinal.Presenters.MenuPrincipalPresentersImp;
import fi.unju.edu.ar.tpfinal.Presenters.ProductoPresenterImp;
import fi.unju.edu.ar.tpfinal.R;

//import fi.unju.edu.ar.tpfinal.R;
public class MenuPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private MenuPrincipalPresenter menuPrincipalPresenter;
    private MenuPrincipalInteractor menuPrincipalInteractor;
    private ListView listView;
    private ArrayList<Producto> lista;
    ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        menuPrincipalPresenter = new MenuPrincipalPresentersImp(this);



    }

    public void mostrarProductos(View v){
        ProductoFragment fragment = new ProductoFragment();

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
        return true;
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
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
