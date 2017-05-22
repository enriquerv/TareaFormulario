package com.luisenrique.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DatosContacto extends AppCompatActivity {

    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;
    private String fecha;
    private int anio;
    private int mes;
    private int dia;
    private String diaS;
    private String mesS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_contacto);
        editarDatos();

        Bundle parametros = getIntent().getExtras();
        nombre       = parametros.getString("nombre");
        telefono     = parametros.getString("telefono");
        email        = parametros.getString("email");
        descripcion  = parametros.getString("descripcion");
        anio         = parametros.getInt("anio");
        mes          = parametros.getInt("mes");
        dia          = parametros.getInt("dia");

        if(dia   <= 9) diaS = "0"+ Integer.toString(dia);
        else           diaS = Integer.toString(dia);
        if(mes+1 <= 9) mesS = "0"+ Integer.toString(mes+1);
        else           mesS = Integer.toString(mes+1);

        fecha        = diaS +"/"+mesS+"/"+Integer.toString(anio);

        TextView tvNombre       = (TextView) findViewById(R.id.tvNombre);
        TextView tvTelefono     = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail        = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion  = (TextView) findViewById(R.id.tvDescripcion);
        TextView tvfecha        = (TextView) findViewById(R.id.tvFecha);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
        tvfecha.setText(fecha);
    }

    public void editarDatos(){
        Button btnEditar  = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatosContacto.this, MainActivity.class);
                intent.putExtra("nombre",nombre);
                intent.putExtra("telefono",telefono);
                intent.putExtra("email",email);
                intent.putExtra("descripcion", descripcion);
                intent.putExtra("anio", anio);
                intent.putExtra("mes", mes);
                intent.putExtra("dia", dia);
                startActivity(intent);
                finish();
            }
        });
    }
}
