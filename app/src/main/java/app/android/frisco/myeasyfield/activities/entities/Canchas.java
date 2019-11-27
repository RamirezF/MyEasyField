package app.android.frisco.myeasyfield.activities.entities;

import com.orm.dsl.Table;

@Table
public class Canchas {

    private Long id;
    private String tipo;
    private int num_field;

    public Canchas(String tipo, int num_field) {
        this.tipo = tipo;
        this.num_field = num_field;
    }

    public Canchas() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNum_field() {
        return num_field;
    }

    public void setNum_field(int num_field) {
        this.num_field = num_field;
    }

    @Override
    public String toString() {
        return "Canchas{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", num_field=" + num_field +
                '}';
    }
}
