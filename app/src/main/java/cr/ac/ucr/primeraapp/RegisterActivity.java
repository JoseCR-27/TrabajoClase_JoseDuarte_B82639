//Jose Andres Duarte Hidalgo B82639
package cr.ac.ucr.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                register();
                break;
            case R.id.btn_goto_login:
                gotoLogin();
                break;
            default:
                break;
        }
    }

    private void register() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(name.isEmpty()){
            etName.setError(getString(R.string.error_name));
            return;
        }

        if(email.isEmpty()){
            etEmail.setError( getString(R.string.error_email) );
            return;
        }

        if(password.isEmpty()){
            etPassword.setError( getString(R.string.error_password) );
            return;
        }

        // TODO: Se tiene que sustituir con la logica de auntentificacion de la aplicacion
        if(name.equalsIgnoreCase("Jose") && email.equalsIgnoreCase("admin@email.com") && "123".equalsIgnoreCase(password)){

            //TODO: enviarlo al main activity

            Toast.makeText(this, R.string.registered, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);

            //Este es un metodo para hacer sobrecarga de metodos(metodos se llaman igual pero reciben parametros distintos)
            startActivity(intent);
            finish();

            //TODO: almacenar en el storage el usuario logueado

        }else{
            Toast.makeText(this, R.string.error_match, Toast.LENGTH_SHORT).show();
        }
    }

    private void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);

        //Este es un metodo para hacer sobrecarga de metodos(metodos se llaman igual pero reciben parametros distintos)
        startActivity(intent);
        finish();
    }
}