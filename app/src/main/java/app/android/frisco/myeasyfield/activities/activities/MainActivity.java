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
            GeneratedRepository.complejo.add(new Complejo("Las Palmas", "Base Aérea Las Plamas Surco", "Ate", "972775699"));
            GeneratedRepository.complejo.add(new Complejo("Marceti Club", "Avenida Husares de Junín - Mz. E Lt. 6 Alt. km. 6.5 de carret", "Ate", "981135181"));
            GeneratedRepository.complejo.add(new Complejo("Sport Plaza", "Av. Nicolas Ayllón 3080", "Ate", "7195850"));
            GeneratedRepository.complejo.add(new Complejo("La Cantera F7", "Av Miguel Grau 494 Santa Clara - Ate Vitarte", "Ate", " 990-566444"));

            GeneratedRepository.complejo.add(new Complejo("Inst Esesuli", "Jr. Recuay 976 Cdra 14 de la Av. Venezuela", "Breña", "4242429"));
            GeneratedRepository.complejo.add(new Complejo("El Centenario de Breña", "Calle Centenario Nº 348 - Alt. Cdra. 7 Av. Brasil", "Breña", "4241993"));
            GeneratedRepository.complejo.add(new Complejo("El Super Golazo", "Colegio Mariano Melgar - Jr Aguarico cdra 12", "Breña", ""));
            GeneratedRepository.complejo.add(new Complejo("La Cancha - Club Venezuela", "Av. Venezuela 1179 - CC. Estrella Plaza 5to Piso", "Breña", "984471883"));

            GeneratedRepository.complejo.add(new Complejo("Forza Futbol", "Calle Los Estudiante s/n (entre calle Matellini y Av El Sol)", "Chorrilos", ""));
            GeneratedRepository.complejo.add(new Complejo("All Soccer - Chorrillos", "CULTURAL LIMA - Av. Alameda Sur 1530 - Villa Chorrillos", "Chorrilos", "655-6384"));
            GeneratedRepository.complejo.add(new Complejo("Campo Villa", "Av. Prolog. Paseo de la República S/N Chorrillos", "Chorrilos", "628-0171"));
            GeneratedRepository.complejo.add(new Complejo("El Corner Futbol Club", "Al costado de la Clinica Maison de Santé", "Chorrilos", "98303333"));

            GeneratedRepository.complejo.add(new Complejo("El Nacional Sport Center", "Av. 28 de julio Nº 501 – Chosica costado de luz de sur ex loc", "Chosica", "628-0171"));

            GeneratedRepository.complejo.add(new Complejo("El Remanso", "Los Huertos de Tungasuca Lt. 67 Comas Lima", "Comas", "998346515"));
            GeneratedRepository.complejo.add(new Complejo("Peloteropolis", "Av. Trapiche 12-B, Comas al lado de El Cortijo", "Comas", "557-6144"));

            GeneratedRepository.complejo.add(new Complejo("Maracanito", "Calle Las Gaviotas Mz Q2 Lt 12 Urb Club de huachipa Esq Call", "Huachipa", "992721974"));

            GeneratedRepository.complejo.add(new Complejo("La Cantera", "Av Industrial 3652 Entre Sodimac y Poder Judicial ", "Independencia", "5423570"));

            GeneratedRepository.complejo.add(new Complejo("Campo Militar de Salaverry", "Av. Salaverry S/N Jesús María (Dentro del Círculo Militar)", "Jesus Maria", "989-591633"));
            GeneratedRepository.complejo.add(new Complejo("Club Lawn Tennis", "Av. República de chile 254", "Jesus Maria", "4671590"));
            GeneratedRepository.complejo.add(new Complejo("Los Proceres Matamula", "Jr Belisario Flores s/n - a 1 cuadra del cruce av. Salaverry", "Jesus Maria", "945067276"));
            GeneratedRepository.complejo.add(new Complejo("Estadio Municipal Campo de Ma", "Campo de Marte", "Jesus Maria", "967781023"));

            GeneratedRepository.complejo.add(new Complejo("Centro Deportivo Real", "Av. El corregidor (Al costado de la iglesia virgen de guadalu", "La Molina", "989156827"));
            GeneratedRepository.complejo.add(new Complejo("El Super Golazo - La Molina", "Urb. Sol de la Molina -Calle Las Bahamas 255", "La Molina", "981299528"));
            GeneratedRepository.complejo.add(new Complejo("El Gramado", "Av La Arboleda 385, Urb. Los Sirius (espaldas de Moliplaza)", "La Molina", "989112242"));
            GeneratedRepository.complejo.add(new Complejo("Entrepelotas Club", "Avenida Los Frutales, 561", "La Molina", "994082592"));

            GeneratedRepository.complejo.add(new Complejo("Tiro Libre", "Raimondy 255 - Frente a Polvos Azules", "La Victoria", "993682892"));
            GeneratedRepository.complejo.add(new Complejo("Matute Gol", "Av Abtao cdra 8 - Cancha Auxiliar del Estadio", "La Victoria", "946171499"));

            GeneratedRepository.complejo.add(new Complejo("Centenario FC - NUEVO LOCAL", "Colegio Republica Dominicana - Clavero Muga 2575", "Cercado de lima", "989-591633"));
            GeneratedRepository.complejo.add(new Complejo("Campo Ocoña", "Jr Ocoña 224 - 4to piso, Cercado de lima", "Cercado de lima", "989-591633"));
            GeneratedRepository.complejo.add(new Complejo("Soccer Club del Peru", "Conjunto Vecinal Mirones, Alt. Cdra 21 y 22 de la Av. Colonia", "Cercado de lima", "989-591633"));

            GeneratedRepository.complejo.add(new Complejo("Club Maracana", "Complejo Mariscal Castilla Alt. Cdra 9 Joaquin Bernal", "Lince", "994082592"));

            GeneratedRepository.complejo.add(new Complejo("Colegio Jose Abelardo Quiñone", "Colegio Jose Abelardo Quiñones Cruce con Jr. Antonio Cabo y T", "Los Olivos", "975556788"));
            GeneratedRepository.complejo.add(new Complejo("DEPORT CENTER", "Jr. Antonio Cabo Cuadra 5 A Espaldas del Estadio Guadalupano", "Los Olivos", "975556788"));
            GeneratedRepository.complejo.add(new Complejo("De Punta al Gol", "Colegio Proceres de la independencia - Mz C Lt14 Km 19.5 Pana", "Los Olivos", "975556788"));

            GeneratedRepository.complejo.add(new Complejo("All Soccer - Campo Lurin", "Av. Manuel Valle y Valle S/N 1 ra. Cda. Lado Izquierdo", "Lurin", "655-6384"));

            GeneratedRepository.complejo.add(new Complejo("Coliseo Chamochumbi", "Jr. Comandante Espinar 300", "Magdalena del Mar", "975556788"));

            GeneratedRepository.complejo.add(new Complejo("San Jorge", "Av. Montagne 360", "Miraflores", "4510001"));
            GeneratedRepository.complejo.add(new Complejo("VILLA SPORT CLUB", "Enrique Caballero 376 (alt Cdra 24 Tomas Marsano)", "Miraflores", "4510001"));
            GeneratedRepository.complejo.add(new Complejo("Costa Verde", "Costa Verde Magdalena del Mar", "Miraflores", "4510001"));

            GeneratedRepository.complejo.add(new Complejo("Club Extremo 22", "Calle Los Claveles - Mz J Lt 7 Urb. Huertos de Pachacamac", "Pachacamac", "994347431"));

            GeneratedRepository.complejo.add(new Complejo("Despelote FC", "Av. Bertelo Cdra 7 (Colegio Simon Bolivar)", "Pueblo Libre", "4510001"));
            GeneratedRepository.complejo.add(new Complejo("Club de Trabajadores del BCRP", "Calle Diego Medina 295 (costado de IPAE)", "Pueblo Libre", "4510001"));
            GeneratedRepository.complejo.add(new Complejo("Torre Tagle", "Calle Jose Ugarteche", "Pueblo Libre", "4510001"));

            GeneratedRepository.complejo.add(new Complejo("San Roque de Rapayan", "Mz. i Lote 4, Av. Las Torres", "Puente Piedra", "962606676 "));
            GeneratedRepository.complejo.add(new Complejo("Las Vegas Stadium", "Urb. Las Vegas Mz. K - Lt. 6 Puente Piedra", "Puente Piedra", "962606676 "));

            GeneratedRepository.complejo.add(new Complejo("All Soccer - Rimac", "Alameda de los Descalzos Nº 202", "Rimac ", "655-6384"));
            GeneratedRepository.complejo.add(new Complejo("Campo Rimac", "Av. Morro de Arica S/N", "Rimac ", "655-6384"));
            GeneratedRepository.complejo.add(new Complejo("El Bernabeu 2", "Jr Huancavelica Cdra 9", "Rimac ", "655-6384"));

            GeneratedRepository.complejo.add(new Complejo("Complejo Liceo Naval", "Alt. Cdra. 24 de Av. San Luis", "San Borja", "998172340 "));
            GeneratedRepository.complejo.add(new Complejo("Los leones", "Ca Siete 170 - Urb Monterrico Norte", "San Borja", "998172340 "));
            GeneratedRepository.complejo.add(new Complejo("El Centenario", "Av. Agustin la Rosa Toro N/A con Av. Javier Prado", "San Borja", "998172340 "));

            GeneratedRepository.complejo.add(new Complejo("Complejo Orrantia", "Av Godofreo Garcia Cdra 4 - Alt cdra 18 de Av El Ejercito", "San Isidro", "998172340"));

            GeneratedRepository.complejo.add(new Complejo("77 SPORT", "Av. Lurigancho 991 costado de Aldeas Infantiles S.O.S", "San Juan de Lurigancho", "981086579"));
            GeneratedRepository.complejo.add(new Complejo("EL CAMPIN", "Jr. Kotosh s/n Lot 2", "San Juan de Lurigancho", "981086579"));
            GeneratedRepository.complejo.add(new Complejo("Campo Deportivo Stadium", "Av. Piramide del Sol 780 (Cruce con Jr. Las Mercedes)", "San Juan de Lurigancho", "981086579"));

            GeneratedRepository.complejo.add(new Complejo("Cancha la 10 - SJM", "Avenida Vargas Machuca Cdra., 3", "San Juan de Miraflores", "277-0667"));

            GeneratedRepository.complejo.add(new Complejo("La Bombonera - San Luis", "Jr Río Piura s/n ", "San Luis", "981425553 "));
            GeneratedRepository.complejo.add(new Complejo("La Videna", "Av. Del Aire Cdr 8 con Av Aviación Cdra.20", "San Luis", "981425553 "));

            GeneratedRepository.complejo.add(new Complejo("Complejo Deportivo Hector Chumpitaz", "Av Chillon lt 17 - altura Km 23.5 Panamericana Norte", "San Martin de Porres", "99545495"));
            GeneratedRepository.complejo.add(new Complejo("DEPORCENTRO SMP", "los Canelos 245", "San Martin de Porres", "99545495"));

            GeneratedRepository.complejo.add(new Complejo("Complejo Deportivo la 9", "Av. Venezuela cdra. 34 s/n", "San Miguel", "997240305 "));
            GeneratedRepository.complejo.add(new Complejo("Complejo Miramar", "Jirón Coronel Inclán, 285", "San Miguel", "997240305 "));
            GeneratedRepository.complejo.add(new Complejo("La Canchita", "Av La Marina S/n Cuadra 11 Colegio Bartolome Herrera", "San Miguel", "997240305 "));

            GeneratedRepository.complejo.add(new Complejo("Nuevo Potrero F.Planet", "Av Combate de Iquique 181", "Surco", "4510001"));
            GeneratedRepository.complejo.add(new Complejo("CANCHITAS VIP", "Calle Monterrey 258 7° Nivel C.C Caminos del Inca", "Surco", "4510001"));
            GeneratedRepository.complejo.add(new Complejo("VillaSport Los Precursores", "Jr. Jose Aguilar Segura s/n", "Surco", "4510001"));

            GeneratedRepository.complejo.add(new Complejo("La Bombonera", "Centro Comercial Plaza hogar", "Surquillo", "4457819"));
            GeneratedRepository.complejo.add(new Complejo("La Once", "Av. Tomás Marsano N° 630", "Surquillo", "4457819"));
            GeneratedRepository.complejo.add(new Complejo("La Diez", "Calle Pablo Neruda 110", "Surquillo", "4457819"));

            GeneratedRepository.complejo.add(new Complejo("Centro Deportivo San Francisco", "Cdra, 50 Av. Pachacutec", "Villa Maria del triunfo", "7191366 "));
            GeneratedRepository.complejo.add(new Complejo("villa sport", "Pachacutec 1355", "Villa Maria del triunfo", "7191366 "));

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
