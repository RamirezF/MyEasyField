package app.android.frisco.myeasyfield.activities.repository;

import android.content.Context;
import android.widget.Toast;
import app.android.frisco.myeasyfield.activities.entities.Complejo;
import com.orm.SugarRecord;

import java.util.List;

public class CanchasRepository {

    public static List<Complejo> findByDistrict(String distrito, Context context){
        List<Complejo> complejos = SugarRecord.find(Complejo.class,"DISTRICT = '"+distrito+"'");
        List<Complejo> todos = SugarRecord.listAll(Complejo.class);
        if (complejos.isEmpty()){
            Toast.makeText(context, "Lo siento, no encontramos complejos registrados en ese distrito. Se le " +
                    "mostrará todos los complejos nuevamente", Toast.LENGTH_LONG).show();
            return todos;
        }else{
            return complejos;
        }

    }

}
