package app.android.frisco.myeasyfield.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import app.android.frisco.myeasyfield.R;

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
    }

    public void ingresar(){
        Intent intent=new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
    public void registrate(){
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
