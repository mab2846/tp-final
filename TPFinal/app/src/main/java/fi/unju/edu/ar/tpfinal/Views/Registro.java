package fi.unju.edu.ar.tpfinal.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import fi.unju.edu.ar.tpfinal.Interfaces.RegistroPresenter;
import fi.unju.edu.ar.tpfinal.Interfaces.RegistroView;
import fi.unju.edu.ar.tpfinal.Presenters.RegistroPresenterImpl;
import fi.unju.edu.ar.tpfinal.R;

public class Registro extends AppCompatActivity implements RegistroView{
    EditText user,mail,name,pass;
    private RegistroPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        user =(EditText) findViewById(R.id.txtUser);
        name =(EditText) findViewById(R.id.txtName);
        mail =(EditText) findViewById(R.id.txtMail);
        pass =(EditText) findViewById(R.id.txtPass);
        presenter = new RegistroPresenterImpl(this);
    }

    @Override
    public void setErrorUser() {
        user.setError("Campo Obligatorio");
    }

    @Override
    public void setErrorName() {
        name.setError("Campo Obligatorio");
    }

    @Override
    public void setErrorMail() {
        mail.setError("Campo Obligatorio");
    }

    @Override
    public void setErrorPass() {
        pass.setError("Campo Obligatorio");
    }

    @Override
    public void navigatePrincipal() {
        startActivity(new Intent(Registro.this, Login.class));
    }

    public void agregar(View v){
        presenter.agregarUsuario(user.getText().toString(), name.getText().toString(),
                mail.getText().toString(), pass.getText().toString(),this);
    }
}
