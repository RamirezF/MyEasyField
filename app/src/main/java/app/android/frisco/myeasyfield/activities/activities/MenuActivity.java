package app.android.frisco.myeasyfield.activities.activities;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import app.android.frisco.myeasyfield.R;
import app.android.frisco.myeasyfield.activities.entities.Canchas;

public class MenuActivity extends AppCompatActivity {

    private ImageButton btnChat, btnNews, btnReserve, btnCamps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnCamps = findViewById(R.id.canchas);
        btnChat = findViewById(R.id.chat);
        btnNews = findViewById(R.id.noticias);
        btnReserve = findViewById(R.id.reservas);

        btnCamps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                canchas();
            }
        });
        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reserva();
            }
        });
    }

    //Activity de búsqueda
    private void canchas(){
        Intent a = new Intent(this, CanchasActivity.class);
        startActivity(a);
    }

    //Activity de reserva realizada
    private void reserva(){
        Intent a = new Intent(this, ReservaActivity.class);
        startActivity(a);
    }
}
