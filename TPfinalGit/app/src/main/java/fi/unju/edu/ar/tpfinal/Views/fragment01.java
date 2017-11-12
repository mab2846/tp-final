package fi.unju.edu.ar.tpfinal.Views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import fi.unju.edu.ar.tpfinal.R;


public class fragment01 extends Fragment {
  @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup contariner,
                             Bundle savedInstanceState){
      return  inflater.inflate(R.layout.fragment_fragment01, contariner,false);
  }
}
