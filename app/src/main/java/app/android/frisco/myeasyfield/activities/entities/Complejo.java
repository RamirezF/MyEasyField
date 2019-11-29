package app.android.frisco.myeasyfield.activities.entities;

import com.orm.dsl.Table;

@Table
public class Complejo {

    private Long id;
    private String name;
    private String address;
    private String district;
    private String phone;
    private double latitud;
    private double longitud;

    public Complejo() {
    }

    public Complejo(String name, String address, String district, String phone, double latitud, double longitud) {
        this.name = name;
        this.address = address;
        this.district = district;
        this.phone = phone;
        this.latitud = latitud;
        this.longitud = longitud;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Complejo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", phone='" + phone + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                '}';
    }
}
