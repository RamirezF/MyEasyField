package app.android.frisco.myeasyfield.activities.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import app.android.frisco.myeasyfield.R;

public class ReservaActivity extends AppCompatActivity {

    private Button back;
    private TextView cancha, precio, complejo, hora, usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        complejo = findViewById(R.id.res_name);
        hora = findViewById(R.id.res_hora);
        cancha = findViewById(R.id.res_direccion);
        usuario = findViewById(R.id.res_usuario);
        precio = findViewById(R.id.res_precio);
        back = findViewById(R.id.res_btn_back);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String dato_usuario = preferences.getString("usuario", "Ninguna reserva hecha");
        String dato_hora = preferences.getString("hora", "Ninguna reserva hecha");
        String datos_precio = preferences.getString("precio", "0.0");
        String dato_complejo = preferences.getString("complejo", "Ninguna reserva hecha");
        String dato_cancha = preferences.getString("cancha", "Ninguna reserva hecha");

        complejo.setText(dato_complejo);
        hora.setText(dato_hora);
        cancha.setText(dato_cancha);
        usuario.setText(dato_usuario);
        precio.setText(datos_precio);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

    }

}
