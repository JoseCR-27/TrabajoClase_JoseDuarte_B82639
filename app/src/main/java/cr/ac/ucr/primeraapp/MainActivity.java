package cr.ac.ucr.primeraapp;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import cr.ac.ucr.primeraapp.utis.AppPreferences;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

    }


    //No es el menu en si sino la carga de cualquier menu que queramos
    @Override
    //En este momento se carga el menu vacio o el cascaron
    public boolean onCreateOptionsMenu(Menu menu) {
        //Asi se carga el menu que nosotros queremos en este cascaron
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.logout:

                logout();
                //Debe devolver algo porque el metodo es boolean
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void logout() {

        AppPreferences.getInstance(this).clear();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public void onClick(View view) {
    }

}