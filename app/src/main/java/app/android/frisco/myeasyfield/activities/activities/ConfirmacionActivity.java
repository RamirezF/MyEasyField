package app.android.frisco.myeasyfield.activities.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import app.android.frisco.myeasyfield.R;
import app.android.frisco.myeasyfield.activities.Paypal.Config;
import app.android.frisco.myeasyfield.activities.entities.Reserva;
import com.orm.SugarRecord;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class ConfirmacionActivity extends AppCompatActivity {

    public static final int PAYPAL_REQUEST_CODE=7171;

    private static PayPalConfiguration config=new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);

    private TextView conf_cancha, conf_horario, conf_complejo;
    private Button back, confirmar;
    public String monto="120";

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        Intent intent=new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);

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

                ProcessPayment();
                //Intent i = new Intent(getApplicationContext(), MenuActivity.class);
                //startActivity(i);
                finish();
            }
        });

    }

    public void ProcessPayment(){
        PayPalPayment payPalPayment=new PayPalPayment(new BigDecimal(String.valueOf(monto)),"USD","pagado por Samantha", PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent=new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    try {
                        String paymentDetails = confirmation.toJSONObject().toString(4);
                        startActivity(new Intent(this, PaymentActivity.class)
                                .putExtra("PaymentDetails", paymentDetails).putExtra("PaymentMount", monto));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == PaymentActivity.RESULT_CANCELED) {
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
            }
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}