package app.android.frisco.myeasyfield.activities.entities;

import com.orm.dsl.Table;

@Table
public class Canchas {

    private Long id;
    private String name;
    private String address;
    private int num_field;

    public Canchas(String name, String address, int num_field) {
        this.name = name;
        this.address = address;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", num_field=" + num_field +
                '}';
    }
}
