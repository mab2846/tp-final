package fi.unju.edu.ar.tpfinal.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import fi.unju.edu.ar.tpfinal.Interfaces.LoginPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.LoginView;
import fi.unju.edu.ar.tpfinal.Presenters.LoginPresenterImpl;
import fi.unju.edu.ar.tpfinal.R;

public class Login extends AppCompatActivity implements LoginView {

    TextView textView;
    EditText editText;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);




        textView = (TextView) findViewById(R.id.textView2);
        editText = (EditText) findViewById(R.id.contraseña);

        SpannableString content = new SpannableString(textView.getText().toString());
        content.setSpan(new UnderlineSpan(), 0,content.length(),0);
        textView.setText(content);

        presenter = new LoginPresenterImpl(this);

        if(presenter.userExist(this)){
            startActivity(new Intent(Login.this,Registro.class));
        }
    }


    @Override
    public void showErrorPass() {
        editText.setError("Campo Obligatorio");

    }

    @Override
    public void showErrorPassLog() {
        editText.setError("Contraseña incorrecta");
    }

    @Override
    public void navigatePrincipal() {
        startActivity(new Intent(Login.this,MenuPrincipal.class));
    }

    public void validar(View v) {
        presenter.validarUsuario(editText.getText().toString(),this);
    }

    public void moveraProductos(View v){
        startActivity(new Intent(Login.this,Categoria.class));
    }
}
