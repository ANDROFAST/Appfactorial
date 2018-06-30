package com.androfast.pc.appfactorial;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edNumero;
    Button bCalcular;
    TextView tRespuesta;
    AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNumero = (EditText) findViewById(R.id.edNumero);
        bCalcular = (Button) findViewById(R.id.bCalcular);
        tRespuesta = (TextView) findViewById(R.id.tRespuesta);

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bCalcular.getText().toString().equals("Limpiar")){
                    edNumero.setText("");
                    edNumero.setEnabled(true);
                    edNumero.requestFocus();
                    tRespuesta.setText("");
                    bCalcular.setText("Calcular");
                }else {
                    if (edNumero.getText().length() == 0) {
                        dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Error");
                        dialog.setMessage("Ingresar el número");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo, int id) {
                                dialogo.cancel();
                                edNumero.requestFocus();
                            }
                        });
                        dialog.show();
                    } else {

                        if (edNumero.getText().toString().equals("")) edNumero.setText("0");
                        long factorial = 1;
                        int num = Integer.parseInt(edNumero.getText().toString());
                        for (int i = 1; i <= num; i++) {
                            factorial = i * factorial;
                        }

                        tRespuesta.setText(String.valueOf(factorial));
                        bCalcular.setText("Limpiar");
                        edNumero.setEnabled(false);
                    }
                }
            }
        });
    }
}

