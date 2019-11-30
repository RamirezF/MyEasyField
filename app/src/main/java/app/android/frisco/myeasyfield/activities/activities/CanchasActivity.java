package app.android.frisco.myeasyfield.activities.activities;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class CanchasActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Spinner distrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canchas);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        distrito = findViewById(R.id.distrito);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        distrito.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mMap.clear();
                String item = parent.getSelectedItem().toString();
                List<Complejo> canchas = CanchasRepository.findByDistrict(item, getApplicationContext());

                for(Complejo c : canchas){
                    LatLng sydney = new LatLng(c.getLatitud(), c.getLongitud());
                    mMap.addMarker(new MarkerOptions().position(sydney).title(c.getName()));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
