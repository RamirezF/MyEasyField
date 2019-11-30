package app.android.frisco.myeasyfield.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import app.android.frisco.myeasyfield.R;

public class ChatActivity extends AppCompatActivity {
    private Button enviar, recibidos, volver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        enviar=findViewById(R.id.btn_enviar);
        recibidos=findViewById(R.id.btn_recibidos);
        volver=findViewById(R.id.btn_volver);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatActivity.this, "Mensaje enviado satisfactoriamente", Toast.LENGTH_SHORT).show();
                chat();
            }
        });

        recibidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChatActivity.this, "No tiene ningún mensaje recibido", Toast.LENGTH_SHORT).show();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresar();
            }
        });
    }

    public void chat(){
        Intent intent=new Intent(this, ChatActivity.class);
        startActivity(intent);
    }

    public void regresar(){
        Intent intent=new Intent(this,MenuActivity.class);
        startActivity(intent);
    }

}
