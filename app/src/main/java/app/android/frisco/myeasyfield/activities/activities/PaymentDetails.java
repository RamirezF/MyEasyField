package app.android.frisco.myeasyfield.activities.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import app.android.frisco.myeasyfield.R;

public class PaymentDetails extends AppCompatActivity {

    private TextView txtId, txtEstatus, txtMonto;
    private Button btn_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        txtId=findViewById(R.id.txtId);
        txtEstatus=findViewById(R.id.txtEstatus);
        txtMonto=findViewById(R.id.txtMonto);
        btn_final=findViewById(R.id.btn_final);

        btn_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });

        Intent intent=getIntent();
        try{
            JSONObject jsonObject=new JSONObject(intent.getStringExtra("PaymentDetails"));
            verDetalles(jsonObject.getJSONObject("response"), intent.getStringExtra("PaymentMount"));
        }catch (JSONException e){

        }
    }

    private void verDetalles(JSONObject response, String monto) {
        try{
            txtId.setText(response.getString("id"));
            txtEstatus.setText(response.getString("state"));
            txtMonto.setText("$"+ monto);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void volver(){
        Intent intent=new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
