package app.android.frisco.myeasyfield.activities.activities;

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

    public void ingresar(){
        Intent intent=new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
    public void registrate(){
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void insert_data(){
        if(GeneratedRepository.usuario.isEmpty() && GeneratedRepository.canchas.isEmpty()
                && GeneratedRepository.complejo.isEmpty() && GeneratedRepository.reserva.isEmpty()){
            //Usuario
            GeneratedRepository.usuario.add(new Usuario("admin", "admin", "admin", "admin@gmail.com", "admin"));

            //Complejo
            GeneratedRepository.complejo.add(new Complejo("Acobamba", "Av. Húsares de Junin Mz. D Lote 2 y 3,", "Ate", "981135181", -12.033633, -76.9241182));
            GeneratedRepository.complejo.add(new Complejo("Sport Plaza", "Av. Nicolas Ayllón 3080", "Ate", "7195850", -12.0231664 ,-76.8907467));
            GeneratedRepository.complejo.add(new Complejo("La Cantera F7", "Av Miguel Grau 494 Santa Clara - Ate Vitarte", "Ate", " 990-566444", -12.0229635, -76.8888127));

            GeneratedRepository.complejo.add(new Complejo("Inst Esesuli", "Jr. Recuay 976 Cdra 14 de la Av. Venezuela", "Breña", "4242429", -12.0560055,-77.055762));
            GeneratedRepository.complejo.add(new Complejo("El Centenario de Breña", "Calle Centenario Nº 348 - Alt. Cdra. 7 Av. Brasil", "Breña", "4241993", -12.0631091, -77.0481631 ));
            GeneratedRepository.complejo.add(new Complejo("El Super Golazo", "Colegio Mariano Melgar - Jr Aguarico cdra 12", "Breña", "", -12.061103, -77.0561218));
            GeneratedRepository.complejo.add(new Complejo("La Cancha - Club Venezuela", "Av. Venezuela 1179 - CC. Estrella Plaza 5to Piso", "Breña", "984471883", -12.0554626 ,-77.0526999));

            GeneratedRepository.complejo.add(new Complejo("Forza Futbol", "Calle Los Estudiante s/n (entre calle Matellini y Av El Sol)", "Chorrilos", "", -12.1926985, -76.9872197));
            GeneratedRepository.complejo.add(new Complejo("All Soccer - Chorrillos", "CULTURAL LIMA - Av. Alameda Sur 1530 - Villa Chorrillos", "Chorrilos", "655-6384", -12.1727196, -77.0022803));
            GeneratedRepository.complejo.add(new Complejo("Campo Villa", "Av. Prolog. Paseo de la República S/N Chorrillos", "Chorrilos", "628-0171", -12.1347336, -77.0198254));
            GeneratedRepository.complejo.add(new Complejo("El Corner Futbol Club", "Al costado de la Clinica Maison de Santé", "Chorrilos", "98303333", -12.1609513 ,-77.0255978));

            GeneratedRepository.complejo.add(new Complejo("El Nacional Sport Center", "Av. 28 de julio Nº 501 – Chosica costado de luz de sur ex loc", "Chosica", "628-0171", -11.9384248, -76.6982833));

            GeneratedRepository.complejo.add(new Complejo("El Remanso", "Los Huertos de Tungasuca Lt. 67 Comas Lima", "Comas", "998346515", -11.8962535, -77.0549458));
            GeneratedRepository.complejo.add(new Complejo("Peloteropolis", "Av. Trapiche 12-B, Comas al lado de El Cortijo", "Comas", "557-6144", -11.917803, -77.0630988));

            GeneratedRepository.complejo.add(new Complejo("Maracanito", "Calle Las Gaviotas Mz Q2 Lt 12 Urb Club de huachipa Esq Call", "Huachipa", "992721974", -12.0178316, -76.9851051));

            GeneratedRepository.complejo.add(new Complejo("La Cantera", "Av Industrial 3652 Entre Sodimac y Poder Judicial ", "Independencia", "5423570", -11.9912786, -77.0613538));

            GeneratedRepository.complejo.add(new Complejo("Campo Militar de Salaverry", "Av. Salaverry S/N Jesús María (Dentro del Círculo Militar)", "Jesus Maria", "989-591633", -12.080905, -77.0472673));
            GeneratedRepository.complejo.add(new Complejo("Club Lawn Tennis", "Av. República de chile 254", "Jesus Maria", "4671590", -12.0561, -77.0480253));
            GeneratedRepository.complejo.add(new Complejo("Los Proceres Matamula", "Jr Belisario Flores s/n - a 1 cuadra del cruce av. Salaverry", "Jesus Maria", "945067276", -12.0830615, -77.0463244));
            GeneratedRepository.complejo.add(new Complejo("Estadio Municipal Campo de Ma", "Campo de Marte", "Jesus Maria", "967781023", -12.070056,-77.0435203));

            GeneratedRepository.complejo.add(new Complejo("El Super Golazo - La Molina", "Urb. Sol de la Molina -Calle Las Bahamas 255", "La Molina", "981299528", -12.0899056,-76.9648648));
            GeneratedRepository.complejo.add(new Complejo("El Gramado", "Av La Arboleda 385, Urb. Los Sirius (espaldas de Moliplaza)", "La Molina", "989112242", -12.0939778,-76.9523972));
            GeneratedRepository.complejo.add(new Complejo("Entrepelotas Club", "Avenida Los Frutales, 561", "La Molina", "994082592", -12.0641084,-76.9669888));

            GeneratedRepository.complejo.add(new Complejo("Tiro Libre", "Raimondy 255 - Frente a Polvos Azules", "La Victoria", "993682892", -12.0607717,-77.0344068));
            GeneratedRepository.complejo.add(new Complejo("Matute Gol", "Av Abtao cdra 8 - Cancha Auxiliar del Estadio", "La Victoria", "946171499", -12.0684486,-77.0247436));

            GeneratedRepository.complejo.add(new Complejo("Centenario FC - NUEVO LOCAL", "Colegio Republica Dominicana - Clavero Muga 2575", "Cercado de lima", "989-591633", -12.0546779,-77.0774245));
            GeneratedRepository.complejo.add(new Complejo("Campo Ocoña", "Jr Ocoña 224 - 4to piso, Cercado de lima", "Cercado de lima", "989-591633", -12.0499905,-77.0383225));
            GeneratedRepository.complejo.add(new Complejo("Soccer Club del Peru", "Conjunto Vecinal Mirones, Alt. Cdra 21 y 22 de la Av. Colonia", "Cercado de lima", "989-591633", -12.0971726,-76.9771985));

            GeneratedRepository.complejo.add(new Complejo("Club Maracana", "Complejo Mariscal Castilla Alt. Cdra 9 Joaquin Bernal", "Lince", "994082592", -12.0873644,-77.0447383));

            GeneratedRepository.complejo.add(new Complejo("Colegio Jose Abelardo Quiñone", "Colegio Jose Abelardo Quiñones Cruce con Jr. Antonio Cabo y T", "Los Olivos", "975556788", -12.0680857,-76.9719275));
            GeneratedRepository.complejo.add(new Complejo("DEPORT CENTER", "Jr. Antonio Cabo Cuadra 5 A Espaldas del Estadio Guadalupano", "Los Olivos", "975556788", -12.008132,-77.0698034));
            GeneratedRepository.complejo.add(new Complejo("De Punta al Gol", "Colegio Proceres de la independencia - Mz C Lt14 Km 19.5 Pana", "Los Olivos", "975556788", -12.0208281,-76.9945613));

            GeneratedRepository.complejo.add(new Complejo("All Soccer - Campo Lurin", "Av. Manuel Valle y Valle S/N 1 ra. Cda. Lado Izquierdo", "Lurin", "655-6384", -12.2827758,-76.8529594));

            GeneratedRepository.complejo.add(new Complejo("Coliseo Chamochumbi", "Jr. Comandante Espinar 300", "Magdalena del Mar", "975556788", -12.0960241,-77.0761734));

            GeneratedRepository.complejo.add(new Complejo("San Jorge", "Av. Montagne 360", "Miraflores", "4510001", -12.1238069,-77.0153377));
            GeneratedRepository.complejo.add(new Complejo("VILLA SPORT CLUB", "Enrique Caballero 376 (alt Cdra 24 Tomas Marsano)", "Miraflores", "4510001", -12.124962,-77.0068337));
            GeneratedRepository.complejo.add(new Complejo("Costa Verde", "Costa Verde Magdalena del Mar", "Miraflores", "4510001", -12.0965432,-77.0774795));

            GeneratedRepository.complejo.add(new Complejo("Club Extremo 22", "Calle Los Claveles - Mz J Lt 7 Urb. Huertos de Pachacamac", "Pachacamac", "994347431", -12.2331607,-76.8642012));

            GeneratedRepository.complejo.add(new Complejo("Despelote FC", "Av. Bertelo Cdra 7 (Colegio Simon Bolivar)", "Pueblo Libre", "4510001", -12.061887,-77.071462));
            GeneratedRepository.complejo.add(new Complejo("Club de Trabajadores del BCRP", "Calle Diego Medina 295 (costado de IPAE)", "Pueblo Libre", "4510001", -12.077607,-77.0802883));
            GeneratedRepository.complejo.add(new Complejo("Torre Tagle", "Calle Jose Ugarteche", "Pueblo Libre", "4510001", -12.0768464,-77.0594485));

            GeneratedRepository.complejo.add(new Complejo("San Roque de Rapayan", "Mz. i Lote 4, Av. Las Torres", "Puente Piedra", "962606676 ", -11.8962479,-77.0671937));
            GeneratedRepository.complejo.add(new Complejo("Las Vegas Stadium", "Urb. Las Vegas Mz. K - Lt. 6 Puente Piedra", "Puente Piedra", "962606676 ", -11.8625591,-77.0665074));

            GeneratedRepository.complejo.add(new Complejo("All Soccer - Rimac", "Alameda de los Descalzos Nº 202", "Rimac ", "655-6384", -12.0227442,-77.0358923));
            GeneratedRepository.complejo.add(new Complejo("Campo Rimac", "Av. Morro de Arica S/N", "Rimac ", "655-6384", -12.0242839,-77.0298994));
            GeneratedRepository.complejo.add(new Complejo("El Bernabeu 2", "Jr Huancavelica Cdra 9", "Rimac ", "655-6384", -12.0578136,-77.0420189));

            GeneratedRepository.complejo.add(new Complejo("Complejo Liceo Naval", "Alt. Cdra. 24 de Av. San Luis", "San Borja", "998172340 ", -12.0966128,-77.000849));
            GeneratedRepository.complejo.add(new Complejo("Los leones", "Ca Siete 170 - Urb Monterrico Norte", "San Borja", "998172340 ", -12.0889812,-76.9831381));
            GeneratedRepository.complejo.add(new Complejo("El Centenario", "Av. Agustin la Rosa Toro N/A con Av. Javier Prado", "San Borja", "998172340 ", -12.1063772,-77.0077685));

            GeneratedRepository.complejo.add(new Complejo("Complejo Orrantia", "Av Godofreo Garcia Cdra 4 - Alt cdra 18 de Av El Ejercito", "San Isidro", "998172340", -12.10827,-77.0578354));

            GeneratedRepository.complejo.add(new Complejo("77 SPORT", "Av. Lurigancho 991 costado de Aldeas Infantiles S.O.S", "San Juan de Lurigancho", "981086579", -12.0170153,-77.0018037));
            GeneratedRepository.complejo.add(new Complejo("EL CAMPIN", "Jr. Kotosh s/n Lot 2", "San Juan de Lurigancho", "981086579", -12.0185255,-76.9932368));
            GeneratedRepository.complejo.add(new Complejo("Campo Deportivo Stadium", "Av. Piramide del Sol 780 (Cruce con Jr. Las Mercedes)", "San Juan de Lurigancho", "981086579", -12.0201776,-77.0013602));

            GeneratedRepository.complejo.add(new Complejo("Cancha la 10 - SJM", "Avenida Vargas Machuca Cdra., 3", "San Juan de Miraflores", "277-0667", -12.1660887,-76.9785621));

            GeneratedRepository.complejo.add(new Complejo("La Bombonera - San Luis", "Jr Río Piura s/n ", "San Luis", "981425553 ", -12.0778519,-77.0045886));
            GeneratedRepository.complejo.add(new Complejo("La Videna", "Av. Del Aire Cdr 8 con Av Aviación Cdra.20", "San Luis", "981425553 ", -12.0813602,-77.0040804));

            GeneratedRepository.complejo.add(new Complejo("Complejo Deportivo Hector Chumpitaz", "Av Chillon lt 17 - altura Km 23.5 Panamericana Norte", "San Martin de Porres", "99545495", -11.9201534,-77.0712724));
            GeneratedRepository.complejo.add(new Complejo("DEPORCENTRO SMP", "los Canelos 245", "San Martin de Porres", "99545495", -12.0126616,-77.0567218));

            GeneratedRepository.complejo.add(new Complejo("Complejo Deportivo la 9", "Av. Venezuela cdra. 34 s/n", "San Miguel", "997240305 ", -12.0625747,-77.0912817));
            GeneratedRepository.complejo.add(new Complejo("Complejo Miramar", "Jirón Coronel Inclán, 285", "San Miguel", "997240305 ", -12.0912448,-77.0904349));
            GeneratedRepository.complejo.add(new Complejo("La Canchita", "Av La Marina S/n Cuadra 11 Colegio Bartolome Herrera", "San Miguel", "997240305 ", -12.1729956,-77.0021824));

            GeneratedRepository.complejo.add(new Complejo("Nuevo Potrero F.Planet", "Av Combate de Iquique 181", "Surco", "4510001", -12.1394528,-77.0084769));
            GeneratedRepository.complejo.add(new Complejo("CANCHITAS VIP", "Calle Monterrey 258 7° Nivel C.C Caminos del Inca", "Surco", "4510001", -12.1136837,-76.9936737));
            GeneratedRepository.complejo.add(new Complejo("VillaSport Los Precursores", "Jr. Jose Aguilar Segura s/n", "Surco", "4510001", -12.1574019,-76.9903471));

            GeneratedRepository.complejo.add(new Complejo("La Bombonera", "Centro Comercial Plaza hogar", "Surquillo", "4457819",-12.112335,-77.0201178 ));
            GeneratedRepository.complejo.add(new Complejo("La Once", "Av. Tomás Marsano N° 630", "Surquillo", "4457819", -12.109521,-77.0167243));
            GeneratedRepository.complejo.add(new Complejo("La Diez", "Calle Pablo Neruda 110", "Surquillo", "4457819", -12.1154331,-77.0179067));

            GeneratedRepository.complejo.add(new Complejo("Centro Deportivo San Francisco", "Cdra, 50 Av. Pachacutec", "Villa Maria del triunfo", "7191366", -12.1911251,-76.9381842));
            GeneratedRepository.complejo.add(new Complejo("villa sport", "Pachacutec 1355", "Villa Maria del triunfo", "7191366 ", -12.1607954,-76.9584764));

            //Canchas
            GeneratedRepository.canchas.add(new Canchas("Grass", 1));
            GeneratedRepository.canchas.add(new Canchas("Grass", 2));
            GeneratedRepository.canchas.add(new Canchas("Grass", 3));
            GeneratedRepository.canchas.add(new Canchas("Grass", 4));
            GeneratedRepository.canchas.add(new Canchas("Loza", 1));
            GeneratedRepository.canchas.add(new Canchas("Loza", 1));

        }
    }
}
