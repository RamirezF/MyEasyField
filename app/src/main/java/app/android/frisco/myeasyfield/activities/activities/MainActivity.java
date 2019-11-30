package app.android.frisco.myeasyfield.activities.activities;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import app.android.frisco.myeasyfield.R;
import app.android.frisco.myeasyfield.activities.entities.Canchas;
import app.android.frisco.myeasyfield.activities.entities.Complejo;
import app.android.frisco.myeasyfield.activities.entities.Usuario;
import app.android.frisco.myeasyfield.activities.repository.GeneratedRepository;
import app.android.frisco.myeasyfield.activities.repository.UsuarioRepository;
import com.orm.SugarRecord;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText password;
    private TextView registrar;
    private Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario=findViewById(R.id.txt_usuario);
        password=findViewById(R.id.txt_password);
        registrar=findViewById(R.id.registrate_txt);
        aceptar=findViewById(R.id.btn_aceptar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrate();
            }
        });

        insert_data();
    }

    //Validación de login
    private void ingresar(){
        String user = usuario.getText().toString();
        String pass = password.getText().toString();
        Usuario u = UsuarioRepository.find(user, pass);
        if (u!=null){
            Intent intent=new Intent(this, MenuActivity.class);
            startActivity(intent);
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            preferences.edit().putString("usuario", user).commit();
            finish();
        }else{
            Toast.makeText(this, "Credenciales incorrectas, verifique el nombre de usuario y contraseña", Toast.LENGTH_SHORT).show();
            usuario.setText("");
            password.setText("");
        }
    }

    //Activity de registro
    private void registrate(){
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    //Insertar data por primera vez
    private void insert_data(){
        if(GeneratedRepository.usuario.isEmpty() && GeneratedRepository.canchas.isEmpty()
                && GeneratedRepository.complejo.isEmpty() && GeneratedRepository.reserva.isEmpty()){
            //Usuario
            GeneratedRepository.usuario.add(new Usuario("admin", "admin", "admin", "admin@gmail.com", "admin"));

            //Complejo
            GeneratedRepository.complejo.add(new Complejo("El Remanso", "Los Huertos de Tungasuca Lt. 67 Comas Lima", "Comas", "998346515", -11.8962535, -77.0549458));
            GeneratedRepository.complejo.add(new Complejo("Peloteropolis", "Av. Trapiche 12-B, Comas al lado de El Cortijo", "Comas", "557-6144", -11.917803, -77.0630988));

            GeneratedRepository.complejo.add(new Complejo("La Cantera", "Av Industrial 3652 Entre Sodimac y Poder Judicial ", "Independencia", "5423570", -11.9912786, -77.0613538));

            GeneratedRepository.complejo.add(new Complejo("Colegio Jose Abelardo Quiñones", "Colegio Jose Abelardo Quiñones Cruce con Jr. Antonio Cabo y T", "Los Olivos", "975556788", -12.0078326,-77.0660689));
            GeneratedRepository.complejo.add(new Complejo("DEPORT CENTER", "Jr. Antonio Cabo Cuadra 5 A Espaldas del Estadio Guadalupano", "Los Olivos", "975556788", -12.008132,-77.0698034));
            GeneratedRepository.complejo.add(new Complejo("De Punta al Gol", "Colegio Proceres de la independencia - Mz C Lt14 Km 19.5 Pana", "Los Olivos", "975556788", -11.95047,-77.062625));

            GeneratedRepository.complejo.add(new Complejo("San Roque de Rapayan", "Mz. i Lote 4, Av. Las Torres", "Puente Piedra", "962606676 ", -11.8962479,-77.0671937));
            GeneratedRepository.complejo.add(new Complejo("Las Vegas Stadium", "Urb. Las Vegas Mz. K - Lt. 6 Puente Piedra", "Puente Piedra", "962606676 ", -11.8625591,-77.0665074));

            GeneratedRepository.complejo.add(new Complejo("Complejo Deportivo Hector Chumpitaz", "Av Chillon lt 17 - altura Km 23.5 Panamericana Norte", "San Martin de Porres", "99545495", -11.9201534,-77.0712724));
            GeneratedRepository.complejo.add(new Complejo("DEPORCENTRO SMP", "los Canelos 245", "San Martin de Porres", "99545495", -12.0126616,-77.0567218));

            //Canchas
            GeneratedRepository.canchas.add(new Canchas("Grass", 1));
            GeneratedRepository.canchas.add(new Canchas("Grass", 2));
            GeneratedRepository.canchas.add(new Canchas("Grass", 3));
            GeneratedRepository.canchas.add(new Canchas("Grass", 4));
            GeneratedRepository.canchas.add(new Canchas("Loza", 1));
            GeneratedRepository.canchas.add(new Canchas("Loza", 1));

            //Guardar las canchas
            for(Canchas can: GeneratedRepository.canchas){
                SugarRecord.save(can);
            }

            //Guardar los complejos
            for(Complejo c: GeneratedRepository.complejo){
                SugarRecord.save(c);
            }

            //Guardar usuario
            for(Usuario u : GeneratedRepository.usuario){
                SugarRecord.save(u);
            }

        }
    }
}

