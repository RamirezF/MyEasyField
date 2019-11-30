package app.android.frisco.myeasyfield.activities.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import app.android.frisco.myeasyfield.R;
import app.android.frisco.myeasyfield.activities.entities.Reserva;
import com.orm.SugarRecord;

public class ConfirmacionActivity extends AppCompatActivity {

    private TextView conf_cancha, conf_horario, conf_complejo;
    private Button back, confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        conf_cancha = findViewById(R.id.conf_direccion);
        conf_complejo = findViewById(R.id.conf_name);
        conf_horario = findViewById(R.id.conf_hora);
        back = findViewById(R.id.back);
        confirmar = findViewById(R.id.btn_confirmar);

        final String complejo = getIntent().getExtras().getString("complejo");
        final String hora = getIntent().getExtras().getString("hora");
        final String cancha = getIntent().getExtras().getString("cancha");

        conf_complejo.setText(complejo);
        conf_horario.setText(hora);
        conf_cancha.setText(cancha);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String usuario = preferences.getString("usuario", null);
                Reserva reserva = new Reserva(usuario, 120.0, hora, complejo, cancha);

                preferences.edit().putString("precio", String.valueOf(120.00))
                                  .putString("hora", hora)
                                  .putString("complejo", complejo)
                                  .putString("cancha", cancha).commit();

                SugarRecord.save(reserva);
                Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(i);
                finish();
                Toast.makeText(getApplicationContext(), "Reserva realizada con éxito", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
