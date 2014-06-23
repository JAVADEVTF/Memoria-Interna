package com.fjrodriguez.memoriainterna;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MyActivity extends Activity {

    static EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        texto = (EditText) findViewById(R.id.editText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void guardar(View view) {
        try {
            FileOutputStream f = openFileOutput("Datos.txt", Context.MODE_PRIVATE);
            OutputStreamWriter FOUT = new OutputStreamWriter(f);
            FOUT.write(texto.getText().toString());
            FOUT.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_LONG);
        }
    }

    public void recuperar(View view) {
        try {
            FileInputStream f = openFileInput("Datos.txt");
            InputStreamReader isr = new InputStreamReader(f);
            BufferedReader FIN = new BufferedReader(isr);
            texto.setText(FIN.readLine());
            FIN.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error: "+e.getMessage(), Toast.LENGTH_LONG);
        }
    }
}
