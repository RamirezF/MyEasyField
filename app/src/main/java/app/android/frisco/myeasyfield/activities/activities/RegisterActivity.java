package app.android.frisco.myeasyfield.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import app.android.frisco.myeasyfield.R;
import app.android.frisco.myeasyfield.activities.repository.UsuarioRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText usuario;
    private EditText correo;
    private EditText clave1;
    private EditText clave2;
    private Button btn_registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nombre=findViewById(R.id.nombretxt);
        apellido=findViewById(R.id.apellidotxt);
        usuario=findViewById(R.id.usuariotxt);
        correo=findViewById(R.id.correotxt);
        clave1=findViewById(R.id.clavetxt);
        clave2=findViewById(R.id.clave2txt);
        btn_registrar=findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registrar();
            }
        });
    }

    public void Registrar(){
        String nom=nombre.getText().toString();
        String apell=apellido.getText().toString();
        String usu=usuario.getText().toString();
        String corr=correo.getText().toString();
        String pass=clave1.getText().toString();

        UsuarioRepository.create(nom, apell, usu, corr, pass);
    }

}