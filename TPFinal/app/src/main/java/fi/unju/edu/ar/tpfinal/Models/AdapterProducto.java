package fi.unju.edu.ar.tpfinal.Models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import fi.unju.edu.ar.tpfinal.R;

/**
 * Created by joel on 08/11/2017.
 */

public class AdapterProducto extends BaseAdapter {
    ArrayList<Producto> productos;
    Context c;

    public AdapterProducto(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            convertView=inflater.inflate(R.layout.item_producto, null);
        }

        TextView nommbreTxt=(TextView)convertView.findViewById(R.id.nombre);
        TextView precioTxt=(TextView)convertView.findViewById(R.id.precio);

        nommbreTxt.setText(productos.get(position).getNombre());
        precioTxt.setText(productos.get(position).getPrecio().toString());

        return convertView;
    }
}
