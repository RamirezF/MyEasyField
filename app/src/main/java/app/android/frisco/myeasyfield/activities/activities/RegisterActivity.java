package app.android.frisco.myeasyfield.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.android.frisco.myeasyfield.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText usuario;
    private EditText correo;
    private EditText clave1;
    private EditText clave2;
    private Button btn_registrar;
    private boolean valid;

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
                validar();
            }
        });
    }

    public void validar(){
        String pass1=" ";
        String pass2="";

        pass1=clave1.getText().toString();
        pass2=clave2.getText().toString();

        if(pass1.equals(pass2)){
            // ver si existe un mismo usuario
            if(if_user_exist()){
                registrar_usuario();
            }else{
                Toast.makeText(this,"Usuario ya registrado", Toast.LENGTH_SHORT).show();
                Toast.makeText(this,"cambio de nombre de usuario",Toast.LENGTH_SHORT).show();
            }

            registrar_usuario();
        }else{
            Toast.makeText(this, "Error en ingresar las claves",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean if_user_exist(){
        boolean validar=false;
        // ver si existe el usuario

        return true;
    }

    public void registrar_usuario(){
        // se registrará el usuario
        String nom,ape,email,user,pass;
        nom=nombre.getText().toString();
        ape=apellido.getText().toString();
        email=correo.getText().toString();
        user=usuario.getText().toString();
        pass=clave1.getText().toString();

    }
}


































