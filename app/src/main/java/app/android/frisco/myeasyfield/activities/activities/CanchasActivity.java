package app.android.frisco.myeasyfield.activities.activities;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;

import app.android.frisco.myeasyfield.R;
import app.android.frisco.myeasyfield.activities.entities.Canchas;
import app.android.frisco.myeasyfield.activities.entities.Complejo;
import app.android.frisco.myeasyfield.activities.repository.CanchasRepository;
import app.android.frisco.myeasyfield.activities.repository.GeneratedRepository;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class CanchasActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Spinner distrito, num_cancha, num_hora;
    private TextView cancha;
    private Button pagar, back;
    private String direccion, hora, conf_cancha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canchas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        distrito = findViewById(R.id.distrito);
        cancha = findViewById(R.id.name_cancha);
        pagar = findViewById(R.id.btnReservar);

        num_cancha = findViewById(R.id.numero_cancha);
        num_hora = findViewById(R.id.horario);

        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ConfirmacionActivity.class);
                i.putExtra("complejo", conf_cancha);
                i.putExtra("hora", num_hora.getSelectedItem().toString());
                i.putExtra("cancha", num_cancha.getSelectedItem().toString());
                startActivity(i);
                finish();
            }
        });


    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        distrito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mMap.clear();
                String item = parent.getSelectedItem().toString();
                List<Complejo> canchas = CanchasRepository.findByDistrict(item, getApplicationContext());

                for(Complejo c : canchas){
                    final LatLng sydney = new LatLng(c.getLatitud(), c.getLongitud());
                     mMap.addMarker(new MarkerOptions().position(sydney).title(c.getName()))
                            .setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mapa));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 11));

                    googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            cancha.setText(marker.getTitle());
                            conf_cancha = marker.getTitle();
                            return true;
                        }

                    });
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
